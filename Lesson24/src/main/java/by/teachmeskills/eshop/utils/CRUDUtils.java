package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.model.Category;
import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CRUDUtils {
    private static final String GET_PRODUCTS_BY_CATEGORY_NAME_QUERY = "SELECT * FROM PRODUCTS WHERE CATEGORY = ?";
    private static final String GET_ALL_CATEGORIES_QUERY = "SELECT * FROM CATEGORIES";
    private static final String GET_USER_BY_NAME_AND_PASS_QUERY = "SELECT * FROM USERS WHERE LOGIN = ? AND PASSWORD = ?";
    private static final String GET_USER_QUERY = "SELECT * FROM USERS WHERE ID = ? AND LOGIN = ? AND NAME = ? AND SURNAME = ? AND PASSWORD = ? AND IMG = ? AND INFO = ?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM USERS WHERE LOGIN = ?";
    private static final String REGISTER_USER_QUERY = "INSERT INTO USERS (LOGIN, NAME, SURNAME, PASSWORD, INFO) VALUE (?, ?, ?, ?, ?)";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM PRODUCTS WHERE ID = ?";

    public static List<Product> getProductsByCategoryName(String categoryName) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY_NAME_QUERY);
            preparedStatement.setString(1, categoryName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                    products.add(createProduct(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String img = rs.getString("img");
                categories.add(Category.builder()
                        .id(id)
                        .description(description)
                        .img(img)
                        .productList(new ArrayList<>())
                        .name(name)
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return categories;
    }

    public static User getUserByLoginAndPassword(String login, String pass) {
        User user = null;
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_NAME_AND_PASS_QUERY);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2,pass);
            ResultSet rs =  preparedStatement.executeQuery();
            user = createUser(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    public static boolean checkUser(User checkedUser) {
        User user = null;
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_QUERY);
            preparedStatement.setInt(1, checkedUser.getId());
            preparedStatement.setString(2, checkedUser.getLogin());
            preparedStatement.setString(3, checkedUser.getName());
            preparedStatement.setString(4, checkedUser.getSurname());
            preparedStatement.setString(5, checkedUser.getPassword());
            preparedStatement.setString(6, checkedUser.getImg());
            preparedStatement.setString(7, checkedUser.getInfo());
            ResultSet rs =  preparedStatement.executeQuery();
            user = createUser(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return checkedUser.equals(user);
    }

    public static boolean checkUserByLogin(String login) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet rs =  preparedStatement.executeQuery();
            if (rs.next()) {
                return false;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return true;
    }

    public static Product getProductById(int id) {
        Product product = null;
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_QUERY);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product = createProduct(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }

    public static void registerUser(User user) {
        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REGISTER_USER_QUERY);
            preparedStatement.setString(1, user.getLogin());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getInfo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Product createProduct(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String description = rs.getString("description");
        String img = rs.getString("img");
        int price = rs.getInt("price");
        return Product.builder()
                .id(id)
                .name(name)
                .description(description)
                .price(price)
                .img(img)
                .build();
    }

    private static User createUser(ResultSet rs) throws SQLException {
        User user = null;
        if (rs.next()) {
            int id = rs.getInt("id");
            String log = rs.getString("login");
            String name = rs.getString("name");
            String password = rs.getString("password");
            String surname = rs.getString("surname");
            String img = rs.getString("img");
            String info = rs.getString("info");
            user = User.builder()
                    .id(id)
                    .login(log)
                    .name(name)
                    .surname(surname)
                    .password(password)
                    .img(img)
                    .info(info)
                    .build();
        }
        return user;
    }
}
