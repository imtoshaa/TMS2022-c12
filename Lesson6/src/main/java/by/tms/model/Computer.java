package by.tms.model;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Computer {
    private String cpu;
    private int ram;
    private int hdd;
    private int cycle;
    private boolean burned; //не сгорел
    private Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public Computer(String cpu, int ram, int hdd, int cycle) {
        this.cpu = cpu;
        this.ram = ram;
        this.hdd = hdd;
        this.cycle = cycle;
    }

    public int getCycle() {
        return cycle;
    }

    public boolean isBurned() {
        return burned;
    }

    public void information() {
        System.out.println("Информация о компьютере" + '\n'
                + "процессор " + cpu + '\n'
                + "оперативная память " + ram + " ГБ" + '\n'
                + "жёсткий диск " + hdd + " ГБ" + '\n'
                + "количество циклов работы = " + cycle);
    }

    public void on() throws InterruptedException {
        if (!burned) {
            loading("Включение");
            if (checkAction() && checkResourceCycles()) {
                System.out.println("*****Компьютер включён*****");
            } else {
                burned();
            }
        } else {
            burned();
        }
    }

    public void off() throws InterruptedException {
        if (!burned) { //если компьютер не сгорел
            loading("Выключение");
            if (checkResourceCycles()) {
                System.out.println("*****Компьютер выключен*****");
                cycleSubtraction();
            }
        } else {
            burned();
        }
    }

    private void cycleSubtraction() {
        cycle--;
        System.out.println("Циклов осталось " + cycle);
    }

    private void burned() {
        burned = true;
        System.out.println("Компьютер сгорел!");
    }

    private boolean checkResourceCycles() {
        return cycle > 0;
    }

    private boolean checkAction() {
        int enteredValue = -1;
        do {
            System.out.println("Внимание! Введите 0 или 1");
            if (scanner.hasNextInt()) {
                enteredValue = scanner.nextInt();
            } else {
                System.out.println("Некорректные данные");
                scanner.next();
            }
        } while (!(enteredValue == 1 || enteredValue == 0));
        return enteredValue == random.nextInt(2);
    }

    private void loading(String label) throws InterruptedException {
        System.out.print(label);
        for (int i = 0; i < 3; i++) {
            TimeUnit.SECONDS.sleep(1);
            System.out.print("...");
        }
        System.out.println();
    }
}
