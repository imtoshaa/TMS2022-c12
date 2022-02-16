package by.teachmeskills.person.jacket;

public class AdidasJacket implements IJacket {
    private boolean isOn;
    private int price;

    @Override
    public void putOn() {
        isOn = true;
        System.out.println("Куртка Адидас надета");
    }

    @Override
    public void takeOff() {
        isOn = false;
        System.out.println("Куртка Адидас снята");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
