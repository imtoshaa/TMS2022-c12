package by.teachmeskills.person.service;

import by.teachmeskills.person.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.person.utils.Brand.*;

public class PersonMain {
    public static void main(String[] args) {
        List<IPerson> persons = new ArrayList<>();

        List<Clothes> clothesVadim = new ArrayList<>();
        clothesVadim.add(new Jacket(new BigDecimal("10"), ADIDAS));
        clothesVadim.add(new Pants(new BigDecimal("10"), ADIDAS));
        clothesVadim.add(new Shoes(new BigDecimal("10"), ADIDAS));
        persons.add(new Person("Вадим", clothesVadim));

        List<Clothes> clothesPavel = new ArrayList<>();
        clothesPavel.add(new Jacket(new BigDecimal("8"), PUMA));
        clothesPavel.add(new Pants(new BigDecimal("3"), ZARA));
        clothesPavel.add(new Shoes(new BigDecimal("15"), ADIDAS));
        persons.add(new Person("Павел", clothesPavel));

        List<Clothes> clothesAnton = new ArrayList<>();
        clothesAnton.add(new Jacket(new BigDecimal("8"), ZARA));
        clothesAnton.add(new Pants(new BigDecimal("4"), ZARA));
        clothesAnton.add(new Shoes(new BigDecimal("11"), PUMA));
        persons.add(new Person("Антон", clothesAnton));

        ClothesShopService clothesShopService = new ClothesShopServiceIpml(persons);
        clothesShopService.putOn();
        clothesShopService.takeOff();
        clothesShopService.putOnWithMaxPrice();
    }
}
