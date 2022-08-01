package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.dao.impl.CategoryDaoImpl;
import by.teachmeskills.eshop.dao.impl.ProductDaoImpl;
import by.teachmeskills.eshop.domain.entities.Category;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.services.ICategoryService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCTS_FROM_CATEGORY;
import static by.teachmeskills.eshop.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORIES;
import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORY;

@Service
public class CategoryServiceImpl implements ICategoryService {

    private final ICategoryDao categoryDao = new CategoryDaoImpl();
    private final IProductDao productDao = new ProductDaoImpl();

    @Override
    public void create(Category entity) throws Exception {
        categoryDao.create(entity);
    }

    @Override
    public List<Category> read() throws Exception {
        return categoryDao.read();
    }

    @Override
    public void update(Category entity) throws Exception {
        categoryDao.update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        categoryDao.delete(id);
    }

    @Override
    public ModelAndView getCategories() throws Exception {
        ModelMap modelMap = new ModelMap();
        List<Category> categories = categoryDao.read();
        modelMap.addAttribute(CATEGORIES, categories);
        return new ModelAndView(HOME_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView getCategoryData(int categoryId) throws Exception {
        ModelMap modelMap = new ModelMap();
        List<Product> products = productDao.getProductsByCategoryId(categoryId);
        modelMap.addAttribute(PRODUCTS_FROM_CATEGORY, products);
        return new ModelAndView(CATEGORY_PAGE.getPath(), modelMap);
    }
}
