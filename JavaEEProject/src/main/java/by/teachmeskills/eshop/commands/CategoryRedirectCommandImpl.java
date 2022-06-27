package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.RequestParamsEnum;
import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Locale;

import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORY_NAME;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.CRUDUtils.getProductsByCategoryName;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

public class CategoryRedirectCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isAuthenticated(user)) {
            String categoryName = request.getParameter(CATEGORY_NAME.getValue());
            List<Product> products = getProductsByCategoryName(categoryName);
            request.setAttribute(categoryName, categoryName.toUpperCase(Locale.ROOT));
            request.setAttribute("productsFromCategory", products);
            return PagesPathEnum.CATEGORY_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();

        }
    }
}
