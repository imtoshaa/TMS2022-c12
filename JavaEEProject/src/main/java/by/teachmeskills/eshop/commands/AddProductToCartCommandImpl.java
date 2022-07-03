package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.exceptions.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.CRUDUtils.getProductById;

public class AddProductToCartCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(AddProductToCartCommandImpl.class);
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
        int productId = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
        Product product = getProductById(productId);
        Cart cart;
        Object objCart = session.getAttribute(SHOPPING_CART.getValue());
        if (objCart != null) {
            cart = (Cart) objCart;
        } else {
            cart = new Cart();
            session.setAttribute(SHOPPING_CART.getValue(), cart);
        }
        cart.addProduct(product);
        log.info("");
        request.setAttribute(PRODUCT.getValue(), product);
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
