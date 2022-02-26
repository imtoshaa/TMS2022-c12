package com.tms.fruits;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
@Setter
public abstract class Fruit {
    private final double weight;
    private double pricePerKilogram;
    private final FruitType typeFruit;

    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    public double getFullPrice() {
        return getPricePerKilogram() * getWeight();
    }

    ;
}
