package by.tms.model;

import by.tms.exceptions.ProductIsNotFound;
import by.tms.exceptions.RepeatIdException;

import java.util.*;

//        * методы:
//        * • добавить товар(принимает объект товара и добавляет его в список
//        * товаров). При попытке добавить товар с id уже существующем в списке,
//        * вставка производится не должна
//        * • получить все товары(метод ВОЗВРАЩАЕТ список всех товаров в
//        * магазине)
//        * • удалить товар (метод принимает id товара и удаляет из списка товар с
//        * соответствующим id)
//        * • редактировать товар(принимает объект товара и редактирует им список
//        * товаров)
public class Shop {

    private final Collection<Product> products = new LinkedHashSet<>();

    public void addProduct(Product product) throws RepeatIdException {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                throw new RepeatIdException("Товар с данным id существует!");
            }
        }
        products.add(product);
    }

    public Collection<Product> getAllProducts() {
        return products;
    }

    public void deleteById(Long id) throws ProductIsNotFound {
        boolean isFound = false;
        for (Product p : products) {
            if (p.getId() == id) {
                products.removeIf(temp -> temp.getId() == id);
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new ProductIsNotFound("Товара не существует!");
        }
    }

    public void edit(Product product) throws ProductIsNotFound {
        boolean isFound = false;
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                isFound = true;
                break;
            }
        }
        if (!isFound) {
            throw new ProductIsNotFound("Товара не существует!");
        }
    }

    public Collection<Product> sortByAscendingPrices() { //попробовал сортировку стримом
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice)).toList();
    }

    public Collection<Product> sortByDescendingPrices() {
        return products.stream()
                .sorted(Comparator.comparingDouble(Product::getPrice).reversed()).toList();
    }

    public Collection<Product> sortByDateOfAddition() {
        List<Product> list = new ArrayList<>(products);
        Collections.reverse(list);
        return list;
    }
}
