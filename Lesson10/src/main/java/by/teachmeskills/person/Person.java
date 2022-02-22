package by.teachmeskills.person;

import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
public class Person implements IPerson {
    private final Clothes shoes;
    private final Clothes pants;
    private final Clothes jacket;
    private final String namePerson;

    public Person(Clothes shoes, Clothes pants, Clothes jacket, String namePerson) {
        this.shoes = shoes;
        this.pants = pants;
        this.jacket = jacket;
        this.namePerson = namePerson;
    }

    @Override
    public void putOn() {
        shoes.putOn();
        pants.putOn();
        jacket.putOn();
    }

    @Override
    public void takeOff() {
        shoes.takeOff();
        pants.takeOff();
        jacket.takeOff();
    }

    @Override
    public BigDecimal getPrice() {
        BigDecimal price = shoes.getPrice().add(pants.getPrice().add(jacket.getPrice()));
        return price;
    }
}
