package by.teachmeskills.person.pants;

import java.math.BigDecimal;

public class Pants implements IPants {
    private BigDecimal price;
    private boolean isOn;
    private String name;

    public Pants(BigDecimal price, String name) {
        this.price = price;
        this.name = name;
    }

    @Override
    public void putOn() {
        if (!isOn) {
            System.out.println("Штаны " + name + " надеты");
            isOn = true;
        }
    }

    @Override
    public void takeOff() {
        if (isOn) {
            System.out.println("Штаны " + name + " сняты");
            isOn = false;
        }
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

}
