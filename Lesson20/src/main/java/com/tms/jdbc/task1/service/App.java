package com.tms.jdbc.task1.service;

import com.tms.jdbc.task1.model.Product;

import static com.tms.jdbc.task1.utils.CRUDUtils.getAllProducts;
import static com.tms.jdbc.task1.utils.CRUDUtils.saveProduct;
import static com.tms.jdbc.task1.utils.CRUDUtils.updateProduct;

public class App {
    public static void main(String[] args) {
        Product product = Product.builder()
                .name("Tomato")
                .info("some info tomato")
                .quantity(222)
                .price(11.1)
                .inStock(false)
                .build();

        saveProduct(product);
        getAllProducts().forEach(System.out::println);
        System.out.println();
        updateProduct(1, 22);
        getAllProducts().forEach(System.out::println);

    }
}
