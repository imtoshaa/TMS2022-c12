package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.domain.User;

import static by.teachmeskills.eshop.utils.CRUDUtils.checkUser;

public class UserAuthenticationUtils {

    public static boolean isAuthenticated(User user) {
        return user != null && checkUser(user);
    }
}
