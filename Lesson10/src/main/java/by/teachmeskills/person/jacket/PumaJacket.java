package by.teachmeskills.person.jacket;

public class PumaJacket implements IJacket {
    private boolean isOn;
    private final int price;

    public PumaJacket(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Куртка Пума надета");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Куртка Пума снята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
