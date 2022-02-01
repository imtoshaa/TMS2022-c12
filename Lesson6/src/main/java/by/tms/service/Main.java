package by.tms.service;

import by.tms.model.Computer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Computer asus = new Computer("IntelCore i7", 16, 1024, 5);
        asus.information();
        int command;
        while (true) {
            System.out.println("Введите команду 1 или 0 для включения/выключения компьютера");
            command = scanner.nextInt();
            if (command == 1) {
                asus.on();
            } else if(command == 0) {
                asus.off();
            } else {
                System.out.println("Ошибка! Введена неверная команда");
            }
        }
    }
}
