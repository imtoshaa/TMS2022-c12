package com.tms.fruits;

import static com.tms.fruits.FruitType.*;

public class FruitFactory {
    public static Fruit createFruit(FruitType type, double weight, double pricePerKilogram) {
        Fruit fruit = null;
        switch (type) {
            case APPLE -> fruit = Apple.builder().weight(weight).pricePerKilogram(pricePerKilogram).typeFruit(APPLE).build();
            case APRICOT -> fruit = Apricot.builder().weight(weight).pricePerKilogram(pricePerKilogram).typeFruit(APRICOT).build();
            case PEAR -> fruit = Pear.builder().weight(weight).pricePerKilogram(pricePerKilogram).typeFruit(PEAR).build();
        }
        return fruit;
    }
}
