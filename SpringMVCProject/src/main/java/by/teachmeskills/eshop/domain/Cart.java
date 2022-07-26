package by.teachmeskills.eshop.domain;

import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.impl.OrderServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, Product> products;
    private int totalPrice = 0;

    public Cart() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(products.size(), product);
        totalPrice += product.getPrice();
    }

    public void removeProduct(int productId) {
        Product product = products.get(productId);
        products.remove(productId);
        totalPrice -= product.getPrice();
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void clear() {
        products.clear();
        totalPrice = 0;
    }

    public void buy(User user) throws Exception {
        OrderServiceImpl orderService = new OrderServiceImpl();

        Date orderDate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = sdf.format(orderDate);

        for(Product product : products.values()) {
           Order order = Order.builder()
                   .date(currentTime)
                   .price(product.getPrice())
                   .userId(user.getId())
                   .productId(product.getId())
                   .build();
           orderService.create(order);
        }
        products.clear();
        totalPrice = 0;
    }
}
