package com.tms.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public class Transport {
    private int power;
    private int maxSpeed;
    private int weight;
    private String brand;


    public String info() {
        return "Мощность, л.с. = " + power + '\n'
                + "Мощность, кВт = " + conversionOfPowerToKilowatts(power) + '\n'
                + "Максимальная скорость = " + maxSpeed + '\n'
                + "Масса = " + weight + '\n'
                + "Марка " + brand;
    }

    private double conversionOfPowerToKilowatts(int power) {
        return power * 0.74;
    }
}
