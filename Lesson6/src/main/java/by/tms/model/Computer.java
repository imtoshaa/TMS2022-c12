package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    String cpu;
    int ram;
    int hdd;
    int cycle;
    boolean burned; //не сгорел

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

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    int enter = 2;
    int r;
    public void on() {
        if (!burned) {
            checkAction();

            if (enter == r && checkResourceCycles()) {
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
            if (cycle > 0) {
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
        return cycle >= 0;
    }

    private void checkAction() {
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
//        r = 1;
    }

}
