package by.teachmeskills.eshop.dao;

import by.teachmeskills.eshop.domain.entities.User;

public interface IUserDao extends BaseDao<User> {
    User getUserByLoginAndPassword(String username, String pass) throws Exception;
    boolean checkUser(User checkedUser) throws Exception;
    boolean checkUserByUsername(String username) throws Exception;
}
