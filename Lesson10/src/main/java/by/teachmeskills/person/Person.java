package by.teachmeskills.person;

import by.teachmeskills.person.jacket.IJacket;
import by.teachmeskills.person.pants.IPants;
import by.teachmeskills.person.shoes.IShoes;

public class Person implements IPerson {
    private IShoes shoes;
    private IPants pants;
    private IJacket jacket;

    public Person(IShoes shoes, IPants pants, IJacket jacket) {
        this.shoes = shoes;
        this.pants = pants;
        this.jacket = jacket;
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
    public int getPrice() {
        int price = shoes.getPrice() + pants.getPrice() + jacket.getPrice();
        return price;
    }
}
