package by.teachmeskills.person;

import by.teachmeskills.person.jacket.PumaJacket;
import by.teachmeskills.person.jacket.ZaraJacket;
import by.teachmeskills.person.pants.AdidasPants;
import by.teachmeskills.person.pants.ZaraPants;
import by.teachmeskills.person.shoes.AdidasShoes;
import by.teachmeskills.person.shoes.PumaShoes;
import by.teachmeskills.person.shoes.ZaraShoes;

import java.math.BigDecimal;
import java.util.ArrayList;

public class PersonMain {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(new AdidasShoes(new BigDecimal("1")), new ZaraPants(new BigDecimal("3")), new PumaJacket(new BigDecimal("5"))));
        persons.add(new Person(new PumaShoes(new BigDecimal("3")), new AdidasPants(new BigDecimal("5")), new ZaraJacket(new BigDecimal("4"))));
        persons.add(new Person(new ZaraShoes(new BigDecimal("8")), new ZaraPants(new BigDecimal("3")), new PumaJacket(new BigDecimal("5"))));
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
