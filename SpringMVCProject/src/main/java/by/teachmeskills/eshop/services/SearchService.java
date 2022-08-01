package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.dao.IProductDao;
import by.teachmeskills.eshop.dao.impl.ProductDaoImpl;
import by.teachmeskills.eshop.domain.entities.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.teachmeskills.eshop.utils.PagesPathEnum.SEARCH_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.PRODUCTS_FROM_SEARCH;

@Service
@AllArgsConstructor
public class SearchService {

    private final IProductDao productDao;

    public ModelAndView getSearchResult(String searchQuery) throws Exception {
        ModelMap modelMap = new ModelMap();
        List<Product> allProducts = productDao.read();
        List<Product> searchResult = new ArrayList<>(searchProducts(allProducts, searchQuery));
        modelMap.addAttribute(PRODUCTS_FROM_SEARCH, searchResult);
        return new ModelAndView(SEARCH_PAGE.getPath(), modelMap);
    }

    private Set<Product> searchProducts(List<Product> allProducts, String query) {
        Set<Product> products = new HashSet<>();
        products.addAll(searchByName(allProducts, query));
        products.addAll(searchByDescription(allProducts, query));
        return products;
    }

    private List<Product> searchByName (List<Product> allProducts, String query) {
        List<Product> newProductList = new ArrayList<>();
        for(Product product : allProducts) {
            Matcher matcher = Pattern.compile("\\b" + query + "\\b", Pattern.CASE_INSENSITIVE).matcher(product.getName());
            while (matcher.find()) {
                newProductList.add(product);
            }
        }
        return newProductList;
    }

    private List<Product> searchByDescription (List<Product> allProducts, String query) {
        List<Product> newProductList = new ArrayList<>();
        for(Product product : allProducts) {
            Matcher matcher = Pattern.compile("\\b" + query + "\\b", Pattern.CASE_INSENSITIVE).matcher(product.getDescription());
            while (matcher.find()) {
                newProductList.add(product);
            }
        }
        return newProductList;
    }
}
