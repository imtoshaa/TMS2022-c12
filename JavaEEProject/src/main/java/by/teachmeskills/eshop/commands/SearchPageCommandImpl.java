package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.domain.entities.Product;
import by.teachmeskills.eshop.services.impl.ProductServiceImpl;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.teachmeskills.eshop.PagesPathEnum.SEARCH_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.PRODUCTS_FROM_SEARCH;
import static by.teachmeskills.eshop.RequestParamsEnum.SEARCH_QUERY;

public class SearchPageCommandImpl implements BaseCommand{

    private final ProductServiceImpl productService = new ProductServiceImpl();

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        String query = request.getParameter(SEARCH_QUERY.getValue());
        List<Product> allProducts = productService.read();
        List<Product> searchResult = new ArrayList<>(searchProducts(allProducts, query));
        request.setAttribute(PRODUCTS_FROM_SEARCH.getValue(), searchResult);
        return SEARCH_PAGE.getPath();
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
