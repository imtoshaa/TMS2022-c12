package com.tms.first.model;

public class Odometer { //прибор для измерения пробега автомобиля
    private int fullDistance;


    public int getFullDistance() {
        return fullDistance;
    }

    public void trip() {
        fullDistance += 10;
    }

}
