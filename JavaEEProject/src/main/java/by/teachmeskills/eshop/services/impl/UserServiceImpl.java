package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.impl.UserDaoImpl;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    private final UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public void create(User entity) throws Exception {
        userDao.create(entity);
    }

    @Override
    public List<User> read() throws Exception {
        return userDao.read();
    }

    @Override
    public void update(User entity) throws Exception {
        userDao.update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        userDao.delete(id);
    }

    @Override
    public User getUserByLoginAndPassword(String username, String pass) throws Exception {
        return userDao.getUserByLoginAndPassword(username, pass);
    }

    @Override
    public boolean checkUser(User checkedUser) throws Exception {
        return userDao.checkUser(checkedUser);
    }

    @Override
    public boolean checkUserByUsername(String username) throws Exception {
        return userDao.checkUserByUsername(username);
    }
}
