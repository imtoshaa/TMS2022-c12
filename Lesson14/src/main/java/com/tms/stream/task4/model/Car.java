package com.tms.stream.task4.model;

import lombok.Getter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
public class Car implements Serializable {
//    * 4) Сериализовать объект Автомобиль(Марка, Двигатель(тип двигателя, количество цилиндров),
//    бак(тип топлива, объем), скорость, цена). Количество цилиндров не должно сереализоватся в файл(это конфедициальная информация)
//     * После сериализации произвести обратный процесс(из потока в объект) и вывести на консоль

    private String brand;
    private String engineType;
    transient private int numberOfCylinders;
    private String fuelType;
    private int volumeOfGasTank;
    private int speed;
    private BigDecimal price;

    public Car(String brand, String engineType, int numberOfCylinders, String fuelType, int volumeOfGasTank, int speed, BigDecimal price) {
        this.brand = brand;
        this.engineType = engineType;
        this.numberOfCylinders = numberOfCylinders;
        this.fuelType = fuelType;
        this.volumeOfGasTank = volumeOfGasTank;
        this.speed = speed;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", engineType='" + engineType + '\'' +
                ", numberOfCylinders=" + numberOfCylinders +
                ", fuelType='" + fuelType + '\'' +
                ", volumeOfGasTank=" + volumeOfGasTank +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}
