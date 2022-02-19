package com.tms.fruits;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Pear extends Fruit {
    @Override
    public double getFullPrice() {
        return getPricePerKilogram() * getWeight();
    }
}
