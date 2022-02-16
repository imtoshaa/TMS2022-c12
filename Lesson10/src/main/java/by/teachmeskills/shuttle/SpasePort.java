package by.teachmeskills.shuttle;

import by.teachmeskills.shuttle.start.IStart;

import java.util.concurrent.TimeUnit;

public class SpasePort {

    public SpasePort() {
    }

    public void Start(IStart start) throws InterruptedException {
        if (start.checkStart()) {
            System.out.println("Проверка прошла успешно!");
            for (int i = 10; i >= 1; i--) {
                System.out.println(i + ".....");
                TimeUnit.SECONDS.sleep(1);
            }
            start.engineOn();
            start.start();
        } else {
            System.out.println("Ошибка проверки двигателя! Двигатель не запущен!");
        }
    }
}
