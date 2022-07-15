package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.exceptions.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART_PRODUCTS;

public class RedirectToShoppingCartCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(RedirectToShoppingCartCommandImpl.class);
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        if (cart == null) {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), "");
        } else {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
        }
        log.info("Redirect to cart");
        return CART_PAGE.getPath();
    }
}
