package by.teachmeskills.person.jacket;

public class ZaraJacket implements IJacket {
    private boolean isOn;
    private final int price;

    public ZaraJacket(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Куртка Зара надета");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Куртка Зара снята");
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
