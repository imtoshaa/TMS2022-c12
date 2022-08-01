package by.teachmeskills.eshop.dao;

import by.teachmeskills.eshop.domain.entities.User;
import org.springframework.web.servlet.ModelAndView;

public interface IUserDao extends BaseDao<User> {
    User getUserByLoginAndPassword(String username, String pass) throws Exception;
    boolean checkUser(User checkedUser) throws Exception;
    boolean checkUserByUsername(String username) throws Exception;
}
