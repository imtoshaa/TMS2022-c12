package com.tms.fruits;

import java.util.ArrayList;

public class MainFruits {
    public static void main(String[] args) {
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(createFruit(TypeFruit.APPLE, 2.3, 45));
        fruits.add(createFruit(TypeFruit.APPLE, 5.3, 5));
        fruits.add(createFruit(TypeFruit.APPLE, 4.3, 16));
        fruits.add(createFruit(TypeFruit.APRICOT, 2.8, 2.3));
        fruits.add(createFruit(TypeFruit.APRICOT, 3.1, 5.9));
        fruits.add(createFruit(TypeFruit.APRICOT, 6.8, 3.9));
        fruits.add(createFruit(TypeFruit.PEAR, 2.8, 2.3));
        fruits.add(createFruit(TypeFruit.APRICOT, 2.8, 2.3));
        fruits.add(createFruit(TypeFruit.APRICOT, 2.8, 2.3));
        FruitShop fruitShop = new FruitShop(fruits);
        fruitShop.toSell();
    }

    private static Fruit createFruit(TypeFruit type, double weight, double pricePerKilogram) {
        Fruit fruit = null;
        switch (type) {
            case APPLE -> fruit = Apple.builder().weight(weight).pricePerKilogram(pricePerKilogram).build();
            case APRICOT -> fruit = Apricot.builder().weight(weight).pricePerKilogram(pricePerKilogram).build();
            case PEAR -> fruit = Pear.builder().weight(weight).pricePerKilogram(pricePerKilogram).build();
        }
        return fruit;
    }
}
