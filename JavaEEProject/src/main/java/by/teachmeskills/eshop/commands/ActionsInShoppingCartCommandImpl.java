package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.services.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.ORDER_HISTORY;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

public class ActionsInShoppingCartCommandImpl implements BaseCommand {
    private static final Logger log = LogManager.getLogger(ActionsInShoppingCartCommandImpl.class);

    @Override
    public String execute(HttpServletRequest request) throws Exception {

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
                    User user = (User) request.getSession().getAttribute(USER.getValue());
                    if (isAuthenticated(user)) {
                        cart.buy(user);
                        log.info("Orders are made!");
                    }
                }
                case "remove" -> {
                    cart.removeProduct(Integer.parseInt(request.getParameter("removeId")));
                    request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), cart.getProducts());
                    log.info("Product was removed from cart!");
                }
            }
        }
        return CART_PAGE.getPath();
    }
}
