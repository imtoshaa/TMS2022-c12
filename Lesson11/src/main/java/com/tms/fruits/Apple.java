package com.tms.fruits;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Apple extends Fruit {
    @Override
    public double getFullPrice() {
        return getPricePerKilogram() * getWeight();
    }
}
