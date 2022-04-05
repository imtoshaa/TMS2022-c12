package com.tms.jdbc.task1.utils;

import com.tms.jdbc.task1.model.Product;
import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CRUDUtils {
    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM products";
    private static final String INSERT_STUDENT_QUERY = "INSERT INTO products(name, info, price, quantity, inStock) VALUES(?, ?, ?, ?, ?);";
    private static final String UPDATE_PRODUCT_QUERY = "UPDATE products SET price = ? WHERE id = ?;";
    private static final String DELETE_STUDENT_QUERY = "DELETE FROM products WHERE id = ?";

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String info = rs.getString("info");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                boolean inStock = rs.getBoolean("inStock");
                products.add(Product.builder()
                        .id(id)
                        .quantity(quantity)
                        .info(info)
                        .inStock(inStock)
                        .name(name)
                        .price(price)
                        .build());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }

    public static List<Product> saveProduct(Product product) {
        List<Product> updatedProducts = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_QUERY);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getInfo());
            preparedStatement.setDouble(3, product.getPrice());
            preparedStatement.setInt(4, product.getQuantity());
            preparedStatement.setBoolean(5, product.isInStock());
            preparedStatement.executeUpdate();

            updatedProducts = getAllProducts();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updatedProducts;
    }

    public static List<Product> updateProduct(int productId, int price) {
        List<Product> updatedProducts = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_QUERY);
            preparedStatement.setInt(1, price);
            preparedStatement.setInt(2, productId);
            preparedStatement.executeUpdate();

            updatedProducts = getAllProducts();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updatedProducts;
    }

    public static List<Product> deleteProduct(int productId) {
        List<Product> updatedProducts = new ArrayList<>();

        try (Connection connection = DbUtils.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT_QUERY);
            preparedStatement.setInt(1, productId);
            preparedStatement.execute();

            updatedProducts = getAllProducts();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return updatedProducts;
    }
}
