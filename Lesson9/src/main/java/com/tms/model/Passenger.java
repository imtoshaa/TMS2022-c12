package com.tms.model;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Passenger extends Ground {
    private String bodyType;
    private int passengerNumber;

    @Override
    public String info() {
        return super.info() + '\n'
                + "Тип кузова: " + bodyType + '\n'
                + "Количество посадочных мест = " + passengerNumber;
    }

    public void trip(double time) {
        System.out.println("За время " + time + " ч, автомобиль " + super.getBrand() + ", двигаясь с максимальной скоростью "
        + super.getMaxSpeed() + " км/ч, проедет " + coveredDistance(time) + " км и израсходует " + spentFuel(time) + " литров топлива");
    }

    private double spentFuel(double time) {
        return time * super.getFuelConsumption();
    }

    private double coveredDistance (double time) {
        return super.getMaxSpeed() * time;
    }
}
