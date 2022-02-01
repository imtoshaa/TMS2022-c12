package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String cpu;
    private int ram;
    private int hdd;
    private int cycle;
    private boolean burned; //не сгорел
    Random random = new Random();
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

    public void information() {
        System.out.println("Информация о компьютере" + '\n'
                + "процессор " + cpu + '\n'
                + "оперативная память " + ram + " ГБ" + '\n'
                + "жёсткий диск " + hdd + " ГБ" + '\n'
                + "количество циклов работы = " + cycle);
    }

    int enter = 2;
    int r;
    public void on() {
        if (!burned) {
            do {
                System.out.println("Внимание! Введите 0 или 1");
                if (scanner.hasNextInt()) {
                    enter = scanner.nextInt();
                } else {
                    System.out.println("Некорректные данные");
                    scanner.next();
                }
            } while (!(enter == 1 || enter == 0));
            r = random.nextInt(2);

            if (checkAction(enter, r) && checkResourceCycles()) {
                System.out.println("*****Компьютер включён*****");
            } else {
                burned();
            }
        } else {
            burned();
        }

    }

    public void off() {

        if (!burned) { //если компьютер не сгорел
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

    private boolean checkAction(int enter, int r) {
        return enter == r;
    }

}
