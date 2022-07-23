package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.Product;

import java.util.List;

public interface IProductService extends BaseService<Product> {
    List<Product> getProductsByCategoryId(int categoryId);
    Product getProductById(int productId);
}
