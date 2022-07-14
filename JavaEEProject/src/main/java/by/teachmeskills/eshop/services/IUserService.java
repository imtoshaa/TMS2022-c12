package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.User;

public interface IUserService extends BaseService<User> {

    User getUserByLoginAndPassword(String username, String pass) throws Exception;
    boolean checkUser(User checkedUser) throws Exception;
    boolean checkUserByUsername(String username) throws Exception;
}
