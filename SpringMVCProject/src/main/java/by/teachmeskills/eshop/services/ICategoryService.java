package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.domain.entities.Category;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ICategoryService extends BaseService<Category> {

    ModelAndView getCategories() throws Exception;
    ModelAndView getCategoryData(int categoryId) throws Exception;
}
