package by.teachmeskills.person.shoes;

import by.teachmeskills.person.Clothes;
import by.teachmeskills.person.utils.BrandName;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.SHOES;

@SuperBuilder
public class Shoes extends Clothes implements IShoes {
    private final ClothesType type = SHOES;

    public Shoes(BigDecimal price, BrandName brandName) {
        super(price, brandName);
    }
}
