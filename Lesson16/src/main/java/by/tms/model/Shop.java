package by.tms.model;

import by.tms.exceptions.ProductIsNotFound;
import by.tms.exceptions.RepeatIdException;

import java.util.*;

public class Shop implements ShopAware {

    private final LinkedHashSet<Product> products;

    public Shop(Collection<Product> products) {
        this.products = (LinkedHashSet<Product>) products;
    }

    @Override
    public void addProduct(Product product) throws RepeatIdException {
        if (!products.add(product)) {
                throw new RepeatIdException("Товар с данным id существует!");
        }
    }

    @Override
    public Collection<Product> getAllProducts() {
        return products;
    }

    @Override
    public void deleteById(Long id) throws ProductIsNotFound {
        if (!products.removeIf(temp -> temp.getId() == id)) {
            throw new ProductIsNotFound("Товара не существует!");
        }
    }

    @Override
    public void edit(Product product) throws ProductIsNotFound {
        boolean isFound = false;
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new ProductIsNotFound("Товара не существует!");
        }
    }

    @Override
    public Collection<Product> sortByAscendingPrices() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)).toList();
    }

    @Override
    public Collection<Product> sortByDescendingPrices() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList();
    }

    @Override
    public Collection<Product> sortByDateOfAddition() {
        List<Product> list = new ArrayList<>(products);
        Collections.reverse(list);
        return list;
    }
}
