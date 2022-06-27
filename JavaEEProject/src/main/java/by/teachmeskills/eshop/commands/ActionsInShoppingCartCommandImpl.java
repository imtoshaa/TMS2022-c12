package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART_PRODUCTS;

public class ActionsInShoppingCartCommandImpl implements BaseCommand{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        if (request.getParameter("action") != null && cart != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "clear" -> cart.clear();
                case "buy" -> cart.buy();
            }
        }
        if (request.getParameter("remove") != null && cart != null) {
            cart.removeProduct(Integer.parseInt(request.getParameter("remove")));
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
        }
        return CART_PAGE.getPath();
    }
}
