package by.teachmeskills.person.shoes;

import java.math.BigDecimal;

public class Shoes implements IShoes {
    private BigDecimal price;
    private boolean isOn;
    private String name;

    public Shoes(BigDecimal price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void putOn() {
        if (!isOn) {
            System.out.println("Обувь " + name + " надета");
            isOn = true;
        }
    }

    @Override
    public void takeOff() {
        if (isOn) {
            System.out.println("Обувь " + name + " снята");
            isOn = false;
        }
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
