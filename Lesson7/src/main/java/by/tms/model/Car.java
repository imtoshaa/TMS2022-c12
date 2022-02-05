package by.tms.model;

public class Car {
    private String model; //можно потом добавить
    private String color; //можно потом добавить
    private String bodyType; //можно потом добавить
    private int yearOfRelease; //можно потом добавить
    private final String engineType; //обязательное, нельзя изменить
    private final GasTank gasTank; //обязательное, нельзя изменить
    private int gasTankVolume;
    private Engine engine = new Engine(false);
    private Odometer odometer = new Odometer(0);

    public Car(String engineType, int gasTankVolume) {
        this.engineType = engineType;
        this.gasTank = new GasTank(gasTankVolume);
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public void on() {
        engine.start(gasTank, engine);
    }

    public void off() {
        engine.off();
    }

    public void checkGas() {
        System.out.println("В баке осталост топлива " + gasTank.getVolume() + " единиц из " + gasTank.getFullVolume());
        System.out.println();
    }

    public void fillGas(int value) {
        if (gasTank.getVolume() + value < gasTank.getFullVolume()) {
            gasTank.setVolume(value);
            System.out.println("Машина заправлена на " + value + " единиц");
            System.out.println();
        } else {
            System.out.println("Ошибка! В бак столько не влезет!");
            System.out.println();
        }
    }

    public void driving() {
        if (engine.isOn() && gasTank.getVolume() >= 5) { //машина сжигает 5 единиц топлива за поездку
            System.out.println("*Машина поехала!*");
            gasTank.burningFuel(gasTank,5);
            odometer.trip();
            System.out.println("*Мы приехали!*");
            System.out.println();
        } else {
            System.out.println("Ошибка! Машина не заведена или недостаточно топлива для поездки");
        }
        if (gasTank.getVolume() == 0) { //тут заднумано, что если у нас было топлива только на одну поездку, то при её завершении машина глохнет. тут это и проверяется
            engine.off();
            System.out.println("*Машина заглохла: кончилось топливо*");
        }
    }

    public void checkDistance() {
        System.out.println("Машина проехала за всё время " + odometer.getFullDistance() + " километров пути");
    }

}

class Engine {
    private boolean isOn;

    public Engine(boolean isOn) {
        this.isOn = isOn;
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

class GasTank {

    private int fullVolume;
    private int volume;

    public GasTank(int fullVolume) {
        this.fullVolume = fullVolume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getFullVolume() {
        return fullVolume;
    }

    public void burningFuel(GasTank gasTank, int volume) {
        gasTank.volume -= volume;
    }
}

class Odometer { //прибор для измерения пробега автомобиля
    private int fullDistance;

    public Odometer(int fullDistance) {
        this.fullDistance = fullDistance;
    }

    public int getFullDistance() {
        return fullDistance;
    }

    public void trip() {
        fullDistance += 10;
    }

}
