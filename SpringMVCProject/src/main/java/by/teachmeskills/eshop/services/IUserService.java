package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.User;
import org.springframework.web.servlet.ModelAndView;

public interface IUserService extends BaseService<User> {

    User getUserByLoginAndPassword(String username, String pass) throws Exception;
    boolean checkUser(User checkedUser) throws Exception;
    boolean checkUserByUsername(String username) throws Exception;
    ModelAndView login(User user) throws Exception;
    ModelAndView registration(User user) throws Exception;
    ModelAndView getUserDataForMyPage(User user) throws Exception;
}
