package by.teachmeskills.person.jacket;

import by.teachmeskills.person.Clothes;
import by.teachmeskills.person.utils.Brand;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.JACKET;

@SuperBuilder
public class Jacket extends Clothes {
    private final ClothesType type = JACKET;


    public Jacket(BigDecimal price, Brand brandName) {
        super(price, brandName);
        super.setType(type);
    }

}
