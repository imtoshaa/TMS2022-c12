package by.teachmeskills.person;

import by.teachmeskills.person.jacket.Jacket;
import by.teachmeskills.person.pants.Pants;
import by.teachmeskills.person.shoes.Shoes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.person.utils.BrandName.*;
import static by.teachmeskills.person.utils.ClothesType.*;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        List<ClothesAware> clothesPavel = new ArrayList<>();
        clothesPavel.add(Jacket.builder()
                .brandName(PUMA)
                .price(new BigDecimal("2"))
                .type(JACKET).build());
        clothesPavel.add(Shoes.builder()
                .brandName(ZARA)
                .price(new BigDecimal("3"))
                .type(SHOES).build());
        clothesPavel.add(Pants.builder()
                .brandName(ADIDAS)
                .price(new BigDecimal("9"))
                .type(PANTS).build());
        persons.add(Person.builder()
                .namePerson("Павел")
                .clothes(clothesPavel).build());

        List<ClothesAware> clothesAnton = new ArrayList<>();
        clothesAnton.add(Jacket.builder()
                .brandName(ZARA)
                .price(new BigDecimal("3"))
                .type(JACKET).build());
        clothesAnton.add(Shoes.builder()
                .brandName(ZARA)
                .price(new BigDecimal("4"))
                .type(SHOES).build());
        clothesAnton.add(Pants.builder()
                .brandName(PUMA)
                .price(new BigDecimal("11"))
                .type(PANTS).build());
        persons.add(Person.builder()
                .namePerson("Антон")
                .clothes(clothesPavel).build());

        List<ClothesAware> clothesAvdotiy = new ArrayList<>();
        clothesAvdotiy.add(Jacket.builder()
                .brandName(ADIDAS)
                .price(new BigDecimal("1"))
                .type(JACKET).build());
        clothesAvdotiy.add(Shoes.builder()
                .brandName(ADIDAS)
                .price(new BigDecimal("1"))
                .type(SHOES).build());
        clothesAvdotiy.add(Pants.builder()
                .brandName(ADIDAS)
                .price(new BigDecimal("3"))
                .type(PANTS).build());
        persons.add(Person.builder()
                .namePerson("Павел")
                .clothes(clothesPavel).build());

        BigDecimal max = new BigDecimal("0");
        int indexMax = 0;
        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).putOn();
            System.out.println();
            persons.get(i).takeOff();
            System.out.println();
            if (max.compareTo(persons.get(i).getPrice()) <= 0) {
                max = persons.get(i).getPrice();
                indexMax = i;
            }
        }
        System.out.println("Самый дорогой костюм стоит " + max + ", наденем его");
        System.out.println();
        persons.get(indexMax).putOn();
    }
}
