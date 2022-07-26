package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.dao.impl.ProductDaoImpl;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.services.IProductService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.teachmeskills.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCT;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductDao productDao = new ProductDaoImpl();

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

    @Override
    public ModelAndView getProductData(int productId) throws Exception {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute(PRODUCT, productDao.getProductById(productId));
        return new ModelAndView(PRODUCT_PAGE.getPath(), modelMap);
    }
}
