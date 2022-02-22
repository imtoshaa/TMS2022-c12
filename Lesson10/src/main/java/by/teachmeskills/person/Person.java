package by.teachmeskills.person;

import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@SuperBuilder
public class Person implements IPerson {
    private final String namePerson;
    private final List<ClothesAware> clothes;


    @Override
    public void putOn() {
        for (ClothesAware clothesAware : clothes) {
            clothesAware.putOn();
        }
    }

    @Override
    public void takeOff() {
        for (ClothesAware clothesAware : clothes) {
            clothesAware.takeOff();
        }
    }

    @Override
    public BigDecimal getPrice() {
        return clothes.stream().map(ClothesAware::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        //стримы это клёво!
    }
}
