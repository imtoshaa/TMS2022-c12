package by.teachmeskills.person.jacket;

import by.teachmeskills.person.utils.ClothesType;

import java.math.BigDecimal;

import static by.teachmeskills.person.utils.ClothesType.JACKET;

public interface IJacket {

    ClothesType type = JACKET;

    void putOn();

    void takeOff();

    BigDecimal getPrice();

}
