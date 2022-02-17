package by.teachmeskills.person.shoes;

public class ZaraShoes implements IShoes {
    private boolean isOn;
    private final int price;

    public ZaraShoes(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Обувь Зара надета");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Обувь Зара снята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
