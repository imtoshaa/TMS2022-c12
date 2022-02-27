package by.teachmeskills.person.model;

import by.teachmeskills.person.utils.Brand;
import by.teachmeskills.person.utils.ClothesType;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
public abstract class Clothes {

    private final BigDecimal price;
    private boolean isOn;
    private ClothesType type;
    private final Brand brand;

    public Clothes(BigDecimal price, Brand brandName, ClothesType type) {
        this.price = price;
        this.brand = brandName;
        this.type = type;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    //    public BigDecimal getPrice() {
//        return price;
//    }
}
