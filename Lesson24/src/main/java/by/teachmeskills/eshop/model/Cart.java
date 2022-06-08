package by.teachmeskills.eshop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {

    private Map<Integer, Product> products;
    private Map<Integer, Product> story;
    private int totalPrice = 0;

    public Cart() {
        this.products = new HashMap<>();
        this.story = new HashMap<>();
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

    public Map<Integer, Product> getStory() {
        return story;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void clear() {
        products.clear();
        totalPrice = 0;
    }

    public void buy() {
        story.putAll(products);
        products.clear();
        totalPrice = 0;
    }
}
