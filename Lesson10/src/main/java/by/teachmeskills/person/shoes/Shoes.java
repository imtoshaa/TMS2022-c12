package by.teachmeskills.person.shoes;

import by.teachmeskills.person.Clothes;
import by.teachmeskills.person.utils.Brand;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.SHOES;

@SuperBuilder
public class Shoes extends Clothes {
    private final ClothesType type = SHOES;

    public Shoes(BigDecimal price, Brand brandName) {
        super(price, brandName);
        super.setType(type);
    }
}
