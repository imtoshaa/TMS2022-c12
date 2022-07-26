package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.services.IProductService;
import by.teachmeskills.eshop.services.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("/{productId}")
    public ModelAndView getProductPage(@PathVariable int productId) throws Exception {
        return productService.getProductData(productId);
    }
}
