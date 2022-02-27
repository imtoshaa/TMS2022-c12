package by.teachmeskills.shuttle;

import by.teachmeskills.shuttle.start.IStart;

import java.util.concurrent.TimeUnit;

public class SpasePort {

    public SpasePort() {
    }

    public void start(IStart start) throws InterruptedException {
        //слишком много стартов просто было, поэтому случайно написал, я знаю, что методы с маленькой
        if (start.checkStart()) {
            System.out.println("Проверка прошла успешно!");
            System.out.println("Обратный отсчёт:");
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
