package by.teachmeskills.person.jacket;

import by.teachmeskills.person.Clothes;
import by.teachmeskills.person.utils.BrandName;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.JACKET;

@SuperBuilder
public class Jacket extends Clothes implements IJacket {
    private final ClothesType type = JACKET;


    public Jacket(BigDecimal price, BrandName brandName) {
        super(price, brandName);
    }
}
