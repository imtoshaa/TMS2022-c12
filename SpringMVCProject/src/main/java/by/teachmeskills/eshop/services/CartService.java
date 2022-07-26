package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.dao.impl.ProductDaoImpl;
import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.entities.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.PagesPathEnum.CART_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.SHOPPING_CART_PRODUCTS;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

@Service
public class CartService {

    private final IProductDao productDao = new ProductDaoImpl();

    private static final Logger log = LogManager.getLogger(CartService.class);

    public ModelAndView openCart(Cart cart) {
        ModelMap modelMap = new ModelMap();
        modelMap.addAttribute(SHOPPING_CART_PRODUCTS, cart.getProducts());
        log.info("Redirect to shopping cart.");
        return new ModelAndView(CART_PAGE.getPath(), modelMap);
    }

    public ModelAndView addProductToCart(Cart cart, int productId) throws Exception {
        ModelMap modelMap = new ModelMap();
        cart.addProduct(productDao.getProductById(productId));
        modelMap.addAttribute(SHOPPING_CART_PRODUCTS, cart.getProducts());
        log.info("Product was added to cart");
        return new ModelAndView(CART_PAGE.getPath(), modelMap);
    }

    public ModelAndView removeProduct(Cart cart, int removeId) {
        ModelMap modelMap = new ModelMap();
        cart.removeProduct(removeId);
        modelMap.addAttribute(SHOPPING_CART_PRODUCTS, cart.getProducts());
        log.info("Product was deleted from cart.");
        return new ModelAndView(CART_PAGE.getPath(), modelMap);
    }

    public ModelAndView clearCart(Cart cart) {
        ModelMap modelMap = new ModelMap();
        cart.clear();
        modelMap.addAttribute(SHOPPING_CART_PRODUCTS, cart.getProducts());
        log.info("Shopping cart has been cleared!");
        return new ModelAndView(CART_PAGE.getPath(), modelMap);
    }

    public ModelAndView confirmOrder(Cart cart, User user) throws Exception {
        ModelMap modelMap = new ModelMap();
        if (user != null && isAuthenticated(user)) {
            cart.buy(user);
            modelMap.addAttribute(SHOPPING_CART_PRODUCTS, cart.getProducts());
            log.info("Order is made!");
        } else {
            return new ModelAndView(SIGN_IN_PAGE.getPath());
        }
        return new ModelAndView(CART_PAGE.getPath(), modelMap);
    }
}
