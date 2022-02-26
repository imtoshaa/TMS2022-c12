package com.tms.first.service;

import com.tms.first.model.Car;
import com.tms.first.exception.CarIsNotStartException;

import java.util.Scanner;

public class MainCar {
    public static void main(String[] args) throws CarIsNotStartException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Приветствуем Вас в создании вашего автомобиля!");
//        System.out.println("Введите тип двигателя вашего автомобиля");
//        String typeEngine = scanner.next();
//        System.out.println("Введите желаемый объём бензобака вашего автомобиля");
//        int volume = scanner.nextInt();
        Car myCar = new Car("typeEngine", 10);
        while (true) {
            System.out.println("*****Меню взаимодействия с Вашим автомобилем*****");
            System.out.println("Выберите пункт:");
            System.out.println("* 1 - завести автомобиль" + '\n' +
                    "* 2 - заглушить автомобиль" + '\n' +
                    "* 3 - поехать на автомобиле" + '\n' +
                    "* 4 - проверить количество топлива" + '\n' +
                    "* 5 - заправить автомобиль" + '\n' +
                    "* 6 - узнать пройдённое расстояние" + '\n' +
                    "* 7 - выбрать тип кузова" + '\n' +
                    "* 8 - изменить цвет автомобиля" + '\n' +
                    "* 9 - установить год выпуска автомобиля" + '\n' +
                    "* 10 - установить модель автомобиля" + '\n');
            int enteredNumber = scanner.nextInt();
            switch (enteredNumber) {
                case 0:
                    return;
                case 1:
                    try {
                        myCar.on();
                    } catch (CarIsNotStartException c) {
                        System.out.println(c.getMessage());
                    }
                    break;
                case 2:
                    myCar.off();
                    break;
                case 3:
                    myCar.driving();
                    break;
                case 4:
                    myCar.checkGas();
                    break;
                case 5:
                    System.out.println("Какое количество единиц топлива Вам заправить?");
                    myCar.fillGas(scanner.nextInt());
                    break;
                case 6:
                    myCar.checkDistance();
                    break;
                case 7:
                    System.out.println("Какой тип кузова Вы хотите?");
                    myCar.setBodyType(scanner.next());
                    break;
                case 8:
                    System.out.println("Какой цвет автомобиля Вы хотите?");
                    myCar.setColor(scanner.next());
                    break;
                case 9:
                    System.out.println("Какой год выпуска Вашего автомобиля?");
                    myCar.setYearOfRelease(scanner.nextInt());
                    break;
                case 10:
                    System.out.println("Какая модель Ваш автомобиль?");
                    myCar.setModel(scanner.next());
            }
        }
    }
}
