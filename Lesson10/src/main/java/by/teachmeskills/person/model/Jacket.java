package by.teachmeskills.person.model;

import by.teachmeskills.person.utils.Brand;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.JACKET;

public class Jacket extends Clothes {

    public Jacket(BigDecimal price, Brand brandName) {
        super(price, brandName, JACKET);
    }

}
