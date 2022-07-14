package by.teachmeskills.eshop.dao;

import by.teachmeskills.eshop.domain.entities.Order;

import java.util.Map;

public interface IOrderDao extends BaseDao<Order> {

     Map<Integer, Order> getUserOrderById(int userId) throws Exception;
}
