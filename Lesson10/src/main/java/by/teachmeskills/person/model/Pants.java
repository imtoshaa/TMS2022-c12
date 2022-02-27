package by.teachmeskills.person.model;

import by.teachmeskills.person.utils.Brand;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.PANTS;

public class Pants extends Clothes {

    public Pants(BigDecimal price, Brand brandName) {
        super(price, brandName, PANTS);
    }
}
