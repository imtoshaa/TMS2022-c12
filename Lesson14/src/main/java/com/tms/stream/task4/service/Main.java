package com.tms.stream.task4.service;

import com.tms.stream.task4.model.Car;

import java.io.*;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
                    "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw4\\car.dat"));
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    "D:\\WorkProgrammer\\TMS2022-c12\\Lesson14\\src\\main\\resources\\hw4\\car.dat"));
            Car car = new Car("Ауди", "ДВС", 8, "Дизель", 60, 240, new BigDecimal("21430.30"));
            oos.writeObject(car);
            Car car1 = (Car) ois.readObject();
            System.out.println(car1.toString());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
