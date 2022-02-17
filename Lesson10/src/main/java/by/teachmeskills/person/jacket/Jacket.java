package by.teachmeskills.person.jacket;

import java.math.BigDecimal;

public class Jacket implements IJacket {
    private BigDecimal price;
    private boolean isOn;
    private String name;

    public Jacket(BigDecimal price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void putOn() {
        if (!isOn) {
            System.out.println("Куртка " + name + " надета");
            isOn = true;
        }
    }

    @Override
    public void takeOff() {
        if (isOn) {
            System.out.println("Куртка " + name + " снята");
            isOn = false;
        }
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
