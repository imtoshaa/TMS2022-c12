package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.dao.impl.ProductDaoImpl;
import by.teachmeskills.eshop.domain.entities.Product;

import java.util.List;

public class ProductServiceImpl implements IProductDao {

    private final ProductDaoImpl productDao = new ProductDaoImpl();

    @Override
    public void create(Product entity) throws Exception {
       productDao.create(entity);
    }

    @Override
    public List<Product> read() throws Exception {
        return productDao.read();
    }

    @Override
    public void update(Product entity) throws Exception {
        productDao.update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        productDao.delete(id);
    }

    @Override
    public List<Product> getProductsByCategoryId(int categoryId) throws Exception {
        return productDao.getProductsByCategoryId(categoryId);
    }

    @Override
    public Product getProductById(int productId) throws Exception {
        return productDao.getProductById(productId);
    }
}
