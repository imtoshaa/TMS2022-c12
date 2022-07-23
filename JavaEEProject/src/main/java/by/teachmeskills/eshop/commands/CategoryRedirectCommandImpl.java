package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.services.impl.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORY_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS_FROM_CATEGORY;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

public class CategoryRedirectCommandImpl implements BaseCommand {

    private static final Logger log = LogManager.getLogger(CategoryRedirectCommandImpl.class);
    private final ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isAuthenticated(user)) {
            int categoryId = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
            List<Product> products = productService.getProductsByCategoryId(categoryId);
            request.setAttribute(PRODUCTS_FROM_CATEGORY.getValue(), products);
            log.info("Redirect to " + categoryId);
            return PagesPathEnum.CATEGORY_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}
