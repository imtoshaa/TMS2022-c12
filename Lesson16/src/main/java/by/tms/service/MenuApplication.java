package by.tms.service;

import by.tms.model.Product;
import by.tms.model.ShopAware;

import java.util.Scanner;

public class MenuApplication {
    private final Scanner scanner = new Scanner(System.in);
    private final ShopAware shop;

    public MenuApplication(ShopAware shop) {
        this.shop = shop;
    }

    public void start() {
        System.out.println("Приветствуем в магазине!");
        while (true) {
            System.out.println("*****Меню взаимодействия*****");
            System.out.println("Выберите действие:");
            System.out.println("""
                    * 1 - вывести список товаров
                    * 2 - добавить новый товар в список
                    * 3 - изменение товара
                    * 4 - удалить товар
                    * 0 - выход из меню взаимодействия
                    """);
            int enteredNumber = scanner.nextInt();
            switch (enteredNumber) {
                case 1:
                    System.out.println("""
                            * 1 - по цене (возрастание)
                            * 2 - по цене (убывание)
                            * 3 - по добавлению (сначала новые, потом старые)
                            * 4 - по добавлению (сначала старые, потом новые)
                            """);
                    int enteredNumber1 = scanner.nextInt();
                    switch (enteredNumber1) {
                        case 1:
                            shop.sortByAscendingPrices().forEach(System.out::println);
                            System.out.println();
                            break;
                        case 2:
                            shop.sortByDescendingPrices().forEach(System.out::println);
                            System.out.println();
                            break;
                        case 3:
                            shop.getAllProducts().forEach(System.out::println);
                            System.out.println();
                            break;
                        case 4:
                            shop.sortByDateOfAddition().forEach(System.out::println);
                            System.out.println();
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Введите идентификационный номер товара");
                    long id = scanner.nextLong();
                    System.out.println("Введите название товара");
                    String name = scanner.next();
                    System.out.println("Введите стоимость товара");
                    double price = scanner.nextInt();
                    try {
                        shop.addProduct(new Product(id, name, price));
                        System.out.println("Добавление прошло успешно!");
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Введите идентификационный номер товара, который хотите изменить");
                    long idForEdit = scanner.nextLong();
                    System.out.println("Введите название товара для изменения");
                    String newName = scanner.next();
                    System.out.println("Введите стоимость товара для изменения");
                    double newPrice = scanner.nextDouble();
                    try {
                        shop.edit(new Product(idForEdit, newName, newPrice));
                        System.out.println("Изменение прошло успешно!");
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Введите идентификационный номер товара, который хотите удалить");
                    long idForDelete = scanner.nextLong();
                    try {
                        shop.deleteById(idForDelete);
                        System.out.println("Удаление прошло успешно!");
                        System.out.println();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println();
                    }
                    break;
                case 0:
                    System.out.println("Выход из меню магазина...");
                    return;
            }
        }
    }
}
