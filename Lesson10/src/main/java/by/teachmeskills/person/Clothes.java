package by.teachmeskills.person;

import by.teachmeskills.person.jacket.IJacket;
import by.teachmeskills.person.pants.IPants;
import by.teachmeskills.person.shoes.IShoes;
import by.teachmeskills.person.utils.BrandName;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
public abstract class Clothes implements IJacket, IPants, IShoes {


    private final BigDecimal price;
    private boolean isOn;
    private ClothesType type;
    private final BrandName brandName;


    public Clothes(BigDecimal price, BrandName brandName) {
        this.price = price;
        this.brandName = brandName;
    }

    @Override
    public void putOn() {
        if (!isOn) {
            System.out.println(type.getName() + " " + brandName.getName() + " надета");
            isOn = true;
        }
    }

    @Override
    public void takeOff() {
        if (isOn) {
            System.out.println(type.getName() + " " + brandName.getName() + " снята");
            isOn = false;
        }
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
