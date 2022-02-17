package by.teachmeskills.person.shoes;

public class AdidasShoes implements IShoes {
    private final int price;
    private boolean isOn;

    public AdidasShoes(int price) {
        this.price = price;
    }

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Обувь Адидас надета");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Обувь Адидас снята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
