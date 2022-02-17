package by.teachmeskills.person.pants;

public class PumaPants implements IPants {

    private final int price;
    private boolean isOn;

    public PumaPants(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Штаны Пума надеты");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Штаны Пума сняты");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
