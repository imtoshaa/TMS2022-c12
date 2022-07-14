package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.domain.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements IProductDao {

    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM PRODUCTS";
    private static final String GET_PRODUCT_BY_ID_QUERY = "SELECT * FROM PRODUCTS WHERE ID = ?";
    private static final String GET_PRODUCTS_BY_CATEGORY_ID_QUERY = "SELECT * FROM PRODUCTS WHERE CATEGORY_ID = ?";
    private static final String CREATE_PRODUCT_QUERY = "INSERT INTO PRODUCTS (CATEGORY_ID, NAME, PRICE, DESCRIPTION, IMG) VALUE (?, ?, ?, ?, ?)";
    private static final String DELETE_PRODUCT_QUERY = "DELETE FROM PRODUCTS WHERE ID=?";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE PRODUCTS SET CATEGORY_ID=?, NAME=?, PRICE=?, DESCRIPTION=?, IMG=? WHERE ID=?";

    @Override
    public void create(Product product) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_PRODUCT_QUERY);
            preparedStatement.setString(1, String.valueOf(product.getCategoryId()));
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, String.valueOf(product.getPrice()));
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImg());
            preparedStatement.setString(6,String.valueOf(product.getId()));
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
    public List<Product> read() throws Exception {
        List<Product> products = new ArrayList<>();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(Product.newBuilder().buildProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return products;
    }

    @Override
    public void update(Product product) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUERY);
            preparedStatement.setString(1, String.valueOf(product.getCategoryId()));
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, String.valueOf(product.getPrice()));
            preparedStatement.setString(4, product.getDescription());
            preparedStatement.setString(5, product.getImg());
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_QUERY);
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
    public List<Product> getProductsByCategoryId(int categoryId) throws Exception {
        List<Product> products = new ArrayList<>();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCTS_BY_CATEGORY_ID_QUERY);
            preparedStatement.setString(1, String.valueOf(categoryId));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                products.add(Product.newBuilder().buildProductFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) throws Exception {
        Product product = null;
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_QUERY);
            preparedStatement.setInt(1, productId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                product = Product.newBuilder().buildProductFromResultSet(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return product;
    }

}
