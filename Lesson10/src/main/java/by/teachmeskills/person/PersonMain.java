package by.teachmeskills.person;

import by.teachmeskills.person.jacket.Jacket;
import by.teachmeskills.person.pants.Pants;
import by.teachmeskills.person.shoes.Shoes;

import java.math.BigDecimal;
import java.util.ArrayList;

import static by.teachmeskills.person.utils.BrandName.*;
import static by.teachmeskills.person.utils.ClothesType.*;

public class PersonMain {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
//        persons.add(new Person(new AdidasShoes(new BigDecimal("1")), new ZaraPants(new BigDecimal("3")), new PumaJacket(new BigDecimal("5"))));
//        persons.add(new Person(new PumaShoes(new BigDecimal("3")), new AdidasPants(new BigDecimal("5")), new ZaraJacket(new BigDecimal("4"))));
//        persons.add(new Person(new ZaraShoes(new BigDecimal("8")), new ZaraPants(new BigDecimal("3")), new PumaJacket(new BigDecimal("5"))));
        persons.add(Person.builder()
                .namePerson("Павел")
                .jacket(Jacket.builder()
                        .brandName(PUMA)
                        .price(new BigDecimal("2"))
                        .type(JACKET).build())
                .shoes(Shoes.builder()
                        .brandName(ZARA)
                        .price(new BigDecimal("3"))
                        .type(SHOES).build())
                .pants(Pants.builder()
                        .brandName(ADIDAS)
                        .price(new BigDecimal("9"))
                        .type(PANTS).build()).build());

        persons.add(Person.builder()
                .namePerson("Антон")
                .jacket(Jacket.builder()
                        .brandName(ZARA)
                        .price(new BigDecimal("4"))
                        .type(JACKET).build())
                .shoes(Shoes.builder()
                        .brandName(ZARA)
                        .price(new BigDecimal("3"))
                        .type(SHOES).build())
                .pants(Pants.builder()
                        .brandName(ADIDAS)
                        .price(new BigDecimal("8"))
                        .type(PANTS).build()).build());

        persons.add(Person.builder()
                .namePerson("Авдотий")
                .jacket(Jacket.builder()
                        .brandName(ADIDAS)
                        .price(new BigDecimal("10"))
                        .type(JACKET).build())
                .shoes(Shoes.builder()
                        .brandName(ADIDAS)
                        .price(new BigDecimal("1"))
                        .type(SHOES).build())
                .pants(Pants.builder()
                        .brandName(ADIDAS)
                        .price(new BigDecimal("1"))
                        .type(PANTS).build()).build());

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
