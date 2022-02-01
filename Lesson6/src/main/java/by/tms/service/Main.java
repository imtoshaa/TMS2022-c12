package by.tms.service;

import by.tms.model.Computer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Computer asus = new Computer("IntelCore i7", 16, 1024, 5);
        asus.information();
//        while (true) {
//            System.out.println("Введите команду 1 или 0 для включения/выключения компьютера и команду 2 для выхода из программы");
//            int command = scanner.nextInt();
//            if (command == 1) {
//                asus.on();
//            } else if (command == 0) {
//                asus.off();
//            } else if (command == 2) {
//                return;
//            } else {
//                System.out.println("Ошибка! Введена неверная команда");
//            }
//        }
        for (int i = 0; i < asus.getCycle(); i++) {
            asus.on();
            asus.off(); //да и некрасиво так. если в первый раз сразу комп крашится, то просто 10 раз сгорел и всё
        }
    }
}
