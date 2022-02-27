package com.tms.first.model;

public class Engine {
    private boolean isOn;
    private String engineType;

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public boolean isOn() {
        return isOn;
    }

    public void start(GasTank gasTank) {


        if (!isOn) {
            isOn = true;
            System.out.println("*Двигатель запущен*");
            System.out.println();
        } else {
            System.out.println("Ошибка! Двигатель уже запущен!");
            System.out.println();
        }
    }

    public void off() {
        if (isOn) {
            isOn = false;
            System.out.println("*Двигатель выключен*");
            System.out.println();
        } else {
            System.out.println("Ошибка! Двигатель уже выключен!");
            System.out.println();
        }
    }
}
