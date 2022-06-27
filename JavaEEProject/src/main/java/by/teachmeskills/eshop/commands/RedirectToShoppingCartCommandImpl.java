package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART_PRODUCTS;

public class RedirectToShoppingCartCommandImpl implements BaseCommand{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        if (cart == null) {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), "");
        } else {
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
        }
        return CART_PAGE.getPath();
    }
}
