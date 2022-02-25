package by.teachmeskills.person.pants;

public class AdidasPants implements IPants {

    private final int price;
    private boolean isOn;

    public AdidasPants(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Штаны Адидас надеты");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Штаны Адидас сняты");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
