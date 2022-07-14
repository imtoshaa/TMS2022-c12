package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.Order;

import java.util.Map;

public interface IOrderService extends BaseService<Order>{

    Map<Integer, Order> getUserOrderById(int userId) throws Exception;
}
