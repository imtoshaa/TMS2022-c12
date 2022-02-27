package com.tms.first.model;

import com.tms.first.exception.CarIsNotStartException;

import java.util.Random;

public class Car {
    private String model; //можно потом добавить
    private String color; //можно потом добавить
    private String bodyType; //можно потом добавить
    private int yearOfRelease; //можно потом добавить
    private final GasTank gasTank; //обязательное, нельзя изменить
    private final Engine engine;
    private Odometer odometer = new Odometer();

    public Car(String engineType, int gasTankVolume) {
        this.gasTank = new GasTank(gasTankVolume);
        this.engine = new Engine(engineType);
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void on() throws CarIsNotStartException {
        Random random = new Random();
        if (!engine.isOn()) {
            if (random.nextInt(20) % 2 == 0) {
                if (gasTank.getVolume() > 0) {
                    engine.start(gasTank);
                } else {
                    System.out.println("Двигатель не запущен: нет топлива");
                    System.out.println();
                }
            } else {
                throw new CarIsNotStartException("Машина не завелась!");
            }
        } else {
            System.out.println("Хватит тыкать на единицу, машина и так заведена");
        }

    }

    public void off() {
        engine.off();
    }

    public void checkGas() {
        System.out.println("В баке осталост топлива " + gasTank.getVolume() + " единиц из " + gasTank.getFullVolume());
        System.out.println();
    }

    public void fillGas(int value) {
        if (gasTank.getVolume() + value < gasTank.getFullVolume()) {
            gasTank.setVolume(value);
            System.out.println("Машина заправлена на " + value + " единиц");
            System.out.println();
        } else {
            System.out.println("Ошибка! В бак столько не влезет!");
            System.out.println();
        }
    }

    public void driving() {
        if (engine.isOn() && gasTank.getVolume() >= 5) { //если машина заведена и есть топливо на поездку, то поехали
            System.out.println("*Машина поехала!*");
            gasTank.burningFuel(gasTank, 5); //сжигаем из бака 5 литров
            System.out.println("*Мы приехали!*"); //приехали
            System.out.println();
            if (gasTank.getVolume() == 0) { //если по окончанию поездки топливо на нуле, машина глохнет
                engine.off();
                System.out.println("*Машина заглохла: кончилось топливо*");
                System.out.println();
            }
            odometer.trip();
        } else { // не заведена и нет топлива на поездку
            System.out.println("Ошибка! Машина не заведена или не хватает топлива на поездку!");
            System.out.println();
        }
    }

    public void checkDistance() {
        System.out.println("Машина проехала за всё время " + odometer.getFullDistance() + " километров пути");
    }

}

