package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.Product;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCT_ID;
import static by.teachmeskills.eshop.RequestParamsEnum.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.CRUDUtils.getProductById;

public class AddProductToCartCommandImpl implements BaseCommand{
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        HttpSession session = request.getSession();
//        int productId = 1;
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
        request.setAttribute(PRODUCT.getValue(), product);
        return PagesPathEnum.PRODUCT_PAGE.getPath();
    }
}
