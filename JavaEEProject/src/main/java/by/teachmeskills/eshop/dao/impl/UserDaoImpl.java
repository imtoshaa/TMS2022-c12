package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IUserDao;
import by.teachmeskills.eshop.domain.entities.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {

    private static final String REGISTER_USER_QUERY = "INSERT INTO USERS (USERNAME, NAME, SURNAME, PASSWORD, INFO, EMAIL, BIRTHDAY) VALUE (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_USERNAME = "SELECT * FROM USERS WHERE USERNAME = ?";
    private static final String GET_USER_QUERY = "SELECT * FROM USERS WHERE ID = ?";
    private static final String GET_USER_BY_USERNAME_AND_PASS_QUERY = "SELECT * FROM USERS WHERE USERNAME = ? AND PASSWORD = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM USERS";
    private static final String UPDATE_USER_QUERY = "UPDATE USERS SET USERNAME=?, NAME=?, SURNAME=?, PASSWORD=?, INFO=?, EMAIL=?, BIRTHDAY=? WHERE ID=?";
    private static final String DELETE_USER_QUERY = "DELETE FROM USERS WHERE id=?";

    @Override
    public void create(User user) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER_QUERY);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getInfo());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getBirthday());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }

    @Override
    public List<User> read() throws Exception {
        List<User> users = new ArrayList<>();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                User user = User.newBuilder().buildUserFromResultSet(rs);
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return users;
    }

    @Override
    public void update(User user) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_QUERY);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getInfo());
            preparedStatement.setString(6, user.getEmail());
            preparedStatement.setString(7, user.getBirthday());
            preparedStatement.setString(8, String.valueOf(user.getId()));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_QUERY);
            preparedStatement.setString(1, String.valueOf(id));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }

    @Override
    public User getUserByLoginAndPassword(String username, String pass) throws Exception {
        User user = null;
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME_AND_PASS_QUERY);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, pass);
            ResultSet rs = preparedStatement.executeQuery();
            user = User.newBuilder().buildUserFromResultSet(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return user;
    }

    @Override
    public boolean checkUser(User checkedUser) throws Exception {
        User user = null;
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setInt(1, checkedUser.getId());
            ResultSet rs = preparedStatement.executeQuery();
            user = User.newBuilder().buildUserFromResultSet(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return checkedUser.equals(user);
    }

    @Override
    public boolean checkUserByUsername(String username) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_USERNAME);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return true;
    }
}
