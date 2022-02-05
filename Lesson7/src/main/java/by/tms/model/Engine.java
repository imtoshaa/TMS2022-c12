package by.tms.model;

public class Engine {
    private boolean isOn;
    private String engineType;

    public Engine(String engineType) {
        this.engineType = engineType;
    }

    public boolean isOn() {
        return isOn;
    }

    public void start(GasTank gasTank, Engine engine) {

        if (!engine.isOn) {
            if (gasTank.getVolume() > 0) {
                engine.isOn = true;
                System.out.println("*Двигатель запущен*");
                System.out.println();
            } else {
                System.out.println("Двигатель не запущен: нет топлива");
                System.out.println();
            }
        } else {
            System.out.println("Ошибка! Двигатель уже запущен!");
            System.out.println();
        }
    }

    public void off() {
        if (isOn) {
            isOn = false;
            System.out.println("*Двигатель выключен*");
            System.out.println();
        } else {
            System.out.println("Ошибка! Двигатель уже выключен!");
            System.out.println();
        }
    }
}
