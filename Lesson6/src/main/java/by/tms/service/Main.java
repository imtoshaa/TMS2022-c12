package by.tms.service;

import by.tms.model.Computer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
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
        int cycle = asus.getCycle(); //сделал, чтобы зафиксировать количество изначальных циклов, так как у меня, если остаётся 2 цикла работы, вырубается цикл в main
        for (int i = 0; i < cycle; i++) { // или я что-то не так понял? getCycle в этом if меняется при именении флага cycle в Computer?
            asus.on();
            if (asus.isBurned()) {
                break;
            } else {
                asus.off();
                if (asus.isBurned()) {
                    break;
                }
            }
        }
    }
}
