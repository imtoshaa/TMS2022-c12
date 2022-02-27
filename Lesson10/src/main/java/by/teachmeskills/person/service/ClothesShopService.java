package by.teachmeskills.person.service;

import java.math.BigDecimal;

public interface ClothesShopService {

    void putOn();

    void takeOff();

    void putOnWithMaxPrice();

    BigDecimal getClothesWithMaxPrice();
}
