package com.tms.fruits;

import java.util.ArrayList;

import static com.tms.fruits.TypeFruit.*;

public class MainFruits {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(Seller.createFruit(APPLE, 2.3, 45));
        fruits.add(Seller.createFruit(APPLE, 5.3, 5));
        fruits.add(Seller.createFruit(APPLE, 4.3, 16));
        fruits.add(Seller.createFruit(APRICOT, 2.8, 2.3));
        fruits.add(Seller.createFruit(APRICOT, 3.1, 5.9));
        fruits.add(Seller.createFruit(APRICOT, 6.8, 3.9));
        fruits.add(Seller.createFruit(PEAR, 2.8, 2.3));
        fruits.add(Seller.createFruit(PEAR, 2.8, 2.3));
        fruits.add(Seller.createFruit(PEAR, 2.8, 2.3));
        FruitShop fruitShop = new FruitShop(fruits);
        fruitShop.toSell();
    }
}
