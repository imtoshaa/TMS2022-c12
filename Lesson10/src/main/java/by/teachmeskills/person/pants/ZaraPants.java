package by.teachmeskills.person.pants;

public class ZaraPants implements IPants {
    private final int price;
    private boolean isOn;

    public ZaraPants(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Штаны Зара надеты");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Штаны Зара сняты");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
