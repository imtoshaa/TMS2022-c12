package by.tms.model;

import by.tms.exceptions.ProductIsNotFound;
import by.tms.exceptions.RepeatIdException;

import java.util.Collection;

public interface ShopAware {

    void addProduct(Product product) throws RepeatIdException;
    Collection<Product> getAllProducts();
    void deleteById(Long id) throws ProductIsNotFound;
    void edit(Product product) throws ProductIsNotFound;
    Collection<Product> sortByAscendingPrices();
    Collection<Product> sortByDescendingPrices();
    Collection<Product> sortByDateOfAddition();
}
