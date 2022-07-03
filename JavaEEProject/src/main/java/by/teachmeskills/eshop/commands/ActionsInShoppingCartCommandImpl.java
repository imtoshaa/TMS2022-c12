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

public class ActionsInShoppingCartCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(ActionsInShoppingCartCommandImpl.class);
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute(SHOPPING_CART.getValue());
        if (request.getParameter("action") != null && cart != null) {
            String action = request.getParameter("action");
            switch (action) {
                case "clear" -> {
                    cart.clear();
                    log.info("Cart is cleared!");
                }
                case "buy" -> {
                    cart.buy();
                    log.info("Purchases are made!");
                }
            }
        }
        if (request.getParameter("remove") != null && cart != null) {
            cart.removeProduct(Integer.parseInt(request.getParameter("remove")));
            request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
            log.info("Product was removed from cart!");
        }
        return CART_PAGE.getPath();
    }
}
