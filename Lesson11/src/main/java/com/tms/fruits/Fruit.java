package com.tms.fruits;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Fruit {
    private double weight;
    private double pricePerKilogram;

    public final void printManufacturerInfo() {
        System.out.print("Made in Belarus");
    }

    public abstract double getFullPrice();
}
