package by.teachmeskills.shuttle.start;

import java.util.Random;

public class SpaceX implements IStart {
    @Override
    public boolean checkStart() {
        Random random = new Random();
        return random.nextInt(10) > 3;
    }

    @Override
    public void start() {
        System.out.println("Старт шатла СпэйсИкс!");
    }

    @Override
    public void engineOn() {
        System.out.println("Двигатель шатла СпэйсИкс запущен!");
    }
}
