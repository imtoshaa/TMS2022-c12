package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.domain.Cart;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.SHOPPING_CART;
import static by.teachmeskills.eshop.utils.EshopConstants.USER;

@RestController
@SessionAttributes({SHOPPING_CART, USER})
@RequestMapping("/cart")
@AllArgsConstructor
public class CartController {

    private final CartService cartService;

    @GetMapping("/open")
    public ModelAndView redirectToShoppingCart(@SessionAttribute(SHOPPING_CART) Cart cart) {
        return cartService.openCart(cart);
    }

    @GetMapping("/add/{productId}")
    public ModelAndView addProductToCart(@SessionAttribute(SHOPPING_CART) Cart cart,
                                         @PathVariable int productId) throws Exception {
        return cartService.addProductToCart(cart, productId);
    }

    @GetMapping("/delete/{removeId}")
    public ModelAndView delProductFromCart(@SessionAttribute(SHOPPING_CART) Cart cart,
                                           @PathVariable int removeId){
        return cartService.removeProduct(cart, removeId);
    }

    @GetMapping("/clear")
    public ModelAndView clearUserCart(@SessionAttribute(SHOPPING_CART) Cart cart) {
        return cartService.clearCart(cart);
    }

    @GetMapping("/confirmOrder")
    public ModelAndView confirmOrder(@SessionAttribute(USER) User user,
                                     @SessionAttribute(SHOPPING_CART) Cart cart) throws Exception {
        return cartService.confirmOrder(cart, user);
    }
}
