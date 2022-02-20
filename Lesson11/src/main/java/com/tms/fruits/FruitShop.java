package com.tms.fruits;

import java.util.ArrayList;

public class FruitShop {
    private ArrayList<Fruit> fruits;

    public FruitShop(ArrayList<Fruit> fruits) {
        this.fruits = fruits;
    }

    public void toSell() {
        int count = 0;
        double resultCost = 0;
        for (Fruit fruit : fruits) {
            System.out.println("Фрукт " + fruit.getTypeFruit());
            System.out.println("Цена фрукта за килограмм = " + fruit.getPricePerKilogram());
            System.out.println("Масса фруктов = " + fruit.getWeight());
            System.out.println("Стоимость = " + fruit.getFullPrice());
            System.out.println();
            resultCost += fruit.getFullPrice();
            count++;
        }
        System.out.println("Продано фруктов = " + count);
        System.out.println("Всего заплатили за фрукты = " + resultCost);
    }
}
