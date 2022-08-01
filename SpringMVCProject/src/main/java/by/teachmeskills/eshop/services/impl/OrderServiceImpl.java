package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.IOrderDao;
import by.teachmeskills.eshop.dao.impl.OrderDaoImpl;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.services.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderDao orderDao = new OrderDaoImpl();

    @Override
    public void create(Order entity) throws Exception {
        orderDao.create(entity);
    }

    @Override
    public List<Order> read() throws Exception {
        return orderDao.read();
    }

    @Override
    public void update(Order entity) throws Exception {
        orderDao.update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        orderDao.delete(id);
    }

    @Override
    public Map<Integer, Order> getUserOrderById(int userId) throws Exception {
        return orderDao.getUserOrderById(userId);
    }
}
