package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.PagesPathEnum.PRODUCT_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.CRUDUtils.getProductById;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

public class RedirectProductPageCommandImpl implements BaseCommand{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isAuthenticated(user)) {
            String productId = request.getParameter(PRODUCT_ID.getValue());
            Product product = getProductById(Integer.parseInt(productId));
            request.setAttribute(PRODUCT.getValue(), product);
            return PRODUCT_PAGE.getPath();
        } else {
            return SIGN_IN_PAGE.getPath();
        }
    }
}
