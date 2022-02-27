package by.teachmeskills.person.model;

import by.teachmeskills.person.utils.Brand;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.SHOES;

public class Shoes extends Clothes {

    public Shoes(BigDecimal price, Brand brandName) {
        super(price, brandName, SHOES);
    }
}
