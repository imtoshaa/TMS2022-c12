package by.teachmeskills.person.pants;

import by.teachmeskills.person.Clothes;
import by.teachmeskills.person.utils.Brand;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.PANTS;

@SuperBuilder
public class Pants extends Clothes {
    private final ClothesType type = PANTS;

    public Pants(BigDecimal price, Brand brandName) {
        super(price, brandName);
        super.setType(type);
    }
}
