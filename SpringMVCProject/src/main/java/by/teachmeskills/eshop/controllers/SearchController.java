package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.services.SearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCTS_FROM_SEARCH;

@RestController
@SessionAttributes({PRODUCTS_FROM_SEARCH})
@RequestMapping("/search")
@AllArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @PostMapping
    public ModelAndView getSearchResult(@RequestParam String searchQuery) throws Exception {
        return searchService.getSearchResult(searchQuery);
    }

    @ModelAttribute(PRODUCTS_FROM_SEARCH)
    public List<Product> setUpProductsFromSearch() {
        return new ArrayList<>();
    }
}
