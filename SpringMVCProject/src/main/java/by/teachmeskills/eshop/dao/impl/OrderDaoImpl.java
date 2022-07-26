package by.teachmeskills.eshop.dao.impl;

import by.teachmeskills.eshop.dao.IOrderDao;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDaoImpl implements IOrderDao {

    private ProductDaoImpl productDao = new ProductDaoImpl();

    private static final String GET_USER_ORDERS_QUERY = "SELECT * FROM ORDERS JOIN ORDERS_PRODUCTS OP ON ORDERS.ID = OP.ORDER_ID WHERE USER_ID=?";
    private static final String CREATE_ORDER_QUERY = "INSERT INTO ORDERS (DATE, PRICE, USER_ID) VALUE (?, ?, ?)";
    private static final String GET_ALL_ORDERS_QUERY = "SELECT * FROM ORDERS";
    private static final String UPDATE_ORDER_QUERY = "UPDATE ORDERS SET DATE=?, PRICE=?, USER_ID=? WHERE ID=?";
    private static final String DELETE_ORDER_QUERY = "DELETE FROM ORDERS WHERE ID=?";
    private static final String ADD_PRODUCT_NEW_ORDER = "INSERT INTO ORDERS_PRODUCTS(PRODUCT_ID, ORDER_ID) VALUE (?, LAST_INSERT_ID())";

    @Override
    public void create(Order order) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement createOrder = connection.prepareStatement(CREATE_ORDER_QUERY);
            createOrder.setString(1, String.valueOf(order.getDate()));
            createOrder.setString(2, String.valueOf(order.getPrice()));
            createOrder.setString(3, String.valueOf(order.getUserId()));
            createOrder.executeUpdate();

            PreparedStatement createOrderProduct = connection.prepareStatement(ADD_PRODUCT_NEW_ORDER);
            createOrderProduct.setString(1, String.valueOf(order.getProductId()));
            createOrderProduct.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
    }

    @Override
    public List<Order> read() throws Exception {
        List<Order> orders = new ArrayList<>();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                orders.add(Order.newBuilder().buildOrderFromResultSet(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return orders;
    }

    @Override
    public void update(Order order) throws Exception {
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER_QUERY);
            preparedStatement.setString(1, String.valueOf(order.getDate()));
            preparedStatement.setString(2, String.valueOf(order.getPrice()));
            preparedStatement.setString(3, String.valueOf(order.getUserId()));
            preparedStatement.setString(4, String.valueOf(order.getId()));
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
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_QUERY);
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
    public Map<Integer, Order> getUserOrderById(int userId) throws Exception {
        Map<Integer, Order> userOrders = new HashMap<>();
        Connection connection = pool.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_ORDERS_QUERY);
            preparedStatement.setInt(1, userId);
            ResultSet rs = preparedStatement.executeQuery();
            userOrders = getOrdersByResultSet(rs);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            pool.closeConnection(connection);
        }
        return userOrders;
    }

    private Map<Integer, Order> getOrdersByResultSet(ResultSet resultSet) throws Exception {
        Map<Integer, Order> orderMap = new HashMap<>();
        while (resultSet.next()) {
            int orderID = resultSet.getInt("ID");
            String orderDate = String.valueOf(resultSet.getDate("DATE"));
            int orderPrice = resultSet.getInt("PRICE");
            int productID = resultSet.getInt("PRODUCT_ID");
            int userId = resultSet.getInt("USER_ID");
            Product product = productDao.getProductById(productID);
            orderMap.put(orderID, Order.builder()
                    .id(orderID)
                    .userId(userId)
                    .date(orderDate)
                    .price(orderPrice)
                    .product(product)
                    .build());
        }
        return orderMap;
    }
}
