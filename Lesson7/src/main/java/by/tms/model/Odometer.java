package by.tms.model;

public class Odometer { //прибор для измерения пробега автомобиля
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
