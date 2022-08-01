package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.Product;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface IProductService extends BaseService<Product> {
    List<Product> getProductsByCategoryId(int categoryId) throws Exception;
    Product getProductById(int productId) throws Exception;

    ModelAndView getProductData(int productId) throws Exception;
}
