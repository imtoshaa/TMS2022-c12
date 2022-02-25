package by.teachmeskills.person.shoes;

public class PumaShoes implements IShoes {
    private boolean isOn;
    private final int price;

    public PumaShoes(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Обувь Пума надета");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Обувь Пума снята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
