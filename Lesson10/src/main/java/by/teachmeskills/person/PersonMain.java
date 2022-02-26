package by.teachmeskills.person;

import by.teachmeskills.person.jacket.Jacket;
import by.teachmeskills.person.pants.Pants;
import by.teachmeskills.person.shoes.Shoes;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.person.utils.Brand.*;
import static by.teachmeskills.person.utils.ClothesType.*;

public class PersonMain {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        List<ClothesAware> clothesVadim = new ArrayList<>();
        clothesVadim.add(new Jacket(new BigDecimal("10"), ADIDAS));
        clothesVadim.add(new Pants(new BigDecimal("10"), ADIDAS));
        clothesVadim.add(new Shoes(new BigDecimal("10"), ADIDAS));
        persons.add(Person.builder()
                .namePerson("Вадим")
                .clothes(clothesVadim).build());

        List<ClothesAware> clothesPavel = new ArrayList<>();
        clothesPavel.add(new Jacket(new BigDecimal("8"), PUMA));
        clothesPavel.add(new Pants(new BigDecimal("3"), ZARA));
        clothesPavel.add(new Shoes(new BigDecimal("15"), ADIDAS));
        persons.add(Person.builder()
                .namePerson("Павел")
                .clothes(clothesPavel).build());

        List<ClothesAware> clothesAnton = new ArrayList<>();
        clothesAnton.add(new Jacket(new BigDecimal("8"), ZARA));
        clothesAnton.add(new Pants(new BigDecimal("4"), ZARA));
        clothesAnton.add(new Shoes(new BigDecimal("11"), PUMA));
        persons.add(Person.builder()
                .namePerson("Антон")
                .clothes(clothesAnton).build());

        List<ClothesAware> clothesAvdotiy = new ArrayList<>();
        clothesAvdotiy.add(new Jacket(new BigDecimal("4"), ZARA));
        clothesAvdotiy.add(new Pants(new BigDecimal("1"), ADIDAS));
        clothesAvdotiy.add(new Shoes(new BigDecimal("1"), ZARA));
        persons.add(Person.builder()
                .namePerson("Авдотий")
                .clothes(clothesAvdotiy).build());

        BigDecimal max = BigDecimal.ZERO;
        int indexMax = 0;
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            person.putOn();
            System.out.println();
            person.takeOff();
            System.out.println();
            if (max.compareTo(person.getPrice()) <= 0) {
                max = person.getPrice();
                indexMax = i;
            }
        }
        System.out.println("Самый дорогой костюм стоит " + max + ", наденем его");
        System.out.println();
        persons.get(indexMax).putOn();
    }
}
