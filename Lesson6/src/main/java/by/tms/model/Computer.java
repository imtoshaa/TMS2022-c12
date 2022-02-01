package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    String cpu;
    int ram;
    int hdd;
    int cycle;
    boolean dead = false; //не сгорел
    boolean condition = false; //выключен

    public Computer(String cpu, int ram, int hdd, int cycle) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.cycle = cycle;
    }

    public void information() {
        System.out.println("Информация о компьютере" + '\n'
                + "процессор " + cpu + '\n'
                + "оперативная память " + ram + " ГБ" + '\n'
                + "жёсткий диск " + hdd + " ГБ" + '\n'
                + "количество циклов работы = " + cycle);
    }

    public void on() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int enter = 2;
        if (!condition) {
            if (!dead) {
                do {
                    System.out.println("Внимание! Введите 0 или 1");
                    enter = scanner.nextInt();
                    if (!(enter == 1 || enter == 0)) {
                        System.out.println("Ошибка! Введены некорректные значения");
                    }
                } while (!(enter == 1 || enter == 0));
                int r = random.nextInt(2);
                if (enter == r) {
                    System.out.println("*****Компьютер включён*****");
                    condition = true;
                } else {
                    dead = true;
                    System.out.println("Компьютер сгорел!");
                }
            } else {
                System.out.println("Компьютер сгорел!");
            }
        } else {
            System.out.println("Компьютер уже включён!");
        }
    }

    public void off() {
        if (condition) {
            if (!dead) {
                System.out.println("*****Выключение компьютера*****");
                cycle--;
                condition = false;
                if (cycle < 0) {
                    dead = true;
                }
            }
        } else {
            System.out.println("Компьютер уже выключен!");
        }
    }
}
