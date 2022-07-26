package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;

public class UserAuthenticationUtils {

    public static boolean isAuthenticated(User user) throws Exception {
        UserServiceImpl userService = new UserServiceImpl();
        return user != null && userService.checkUser(user);
    }
}
