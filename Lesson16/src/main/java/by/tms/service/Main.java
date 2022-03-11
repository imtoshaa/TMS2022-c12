package by.tms.service;

import by.tms.model.Product;
import by.tms.model.Shop;
import by.tms.model.ShopAware;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        Shop shop = new Shop();
//
//        shop.addProduct(new Product(1, "Картошка", 12));
//        shop.addProduct(new Product(2, "Морковка", 122));
//        shop.addProduct(new Product(3, "Томат", 16));
//        shop.addProduct(new Product(1, "Картошка", 12));
//        System.out.println(shop.getAllProducts().toString());
//
//        System.out.println("Сортировка прямая");
//        System.out.println(shop.sortByAscendingPrices());
//
//        System.out.println("Сортировка обратная");
//        System.out.println(shop.sortByDescendingPrices());
//
//        System.out.println("Сортировка по дате добавления");
//        System.out.println(shop.sortByDateOfAddition());
//
//        shop.deleteById(12345L);
//        System.out.println(shop.getAllProducts().toString());
//
//        shop.edit(new Product(12347, "Апельсин", 15));
//        System.out.println(shop.getAllProducts().toString());

        LinkedHashSet<Product> products = new LinkedHashSet<>(List.of(
                new Product(1, "Картошка", 12),
                new Product(2, "Морковка", 25),
                new Product(3, "Томат", 16),
                new Product(4, "Яйцо", 14))
        );
        MenuApplication app = new MenuApplication(new Shop(products));
        app.start();


    }
}
