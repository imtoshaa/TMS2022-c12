package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.services.impl.ProductServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

public class RedirectProductPageCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(RedirectProductPageCommandImpl.class);
    private final ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    public String execute(HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isAuthenticated(user)) {
            String productId = request.getParameter(PRODUCT_ID.getValue());
            Product product = productService.getProductById(Integer.parseInt(productId));
            request.setAttribute(PRODUCT.getValue(), product);
            log.info("Redirect to " + product.getName());
            return PRODUCT_PAGE.getPath();
        } else {
            log.info("Come on log in system :)");
            return SIGN_IN_PAGE.getPath();
        }
    }
}
