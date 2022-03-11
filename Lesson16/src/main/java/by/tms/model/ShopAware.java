package by.tms.model;

import by.tms.exceptions.ProductIsNotFound;
import by.tms.exceptions.RepeatIdException;

import java.util.Collection;

public interface ShopAware {

    public void addProduct(Product product) throws RepeatIdException;
    public Collection<Product> getAllProducts();
    public void deleteById(Long id) throws ProductIsNotFound;
    public void edit(Product product) throws ProductIsNotFound;
    public Collection<Product> sortByAscendingPrices();
    public Collection<Product> sortByDescendingPrices();
    public Collection<Product> sortByDateOfAddition();
}
