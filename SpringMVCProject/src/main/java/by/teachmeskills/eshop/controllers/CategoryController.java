package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.ICategoryService;
import by.teachmeskills.eshop.services.impl.CategoryServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORY;
import static by.teachmeskills.eshop.utils.EshopConstants.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.EshopConstants.USER;

@RestController
@SessionAttributes({CATEGORY, USER, SHOPPING_CART})
@RequestMapping("/")
@AllArgsConstructor
public class CategoryController {

    private final ICategoryService categoryService;

    @GetMapping()
    public ModelAndView getCategoriesPage() throws Exception {
        return categoryService.getCategories();
    }

    @GetMapping("/category/{categoryId}")
    public ModelAndView getCategoryPage(@PathVariable int categoryId) throws Exception {
        return categoryService.getCategoryData(categoryId);
    }

    @ModelAttribute(SHOPPING_CART)
    public Cart setUpCart() {
        return new Cart();
    }

    @ModelAttribute(USER)
    public User setUpUser() {
        return new User();
    }
}
