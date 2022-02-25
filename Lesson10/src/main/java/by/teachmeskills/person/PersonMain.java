package by.teachmeskills.person;

import by.teachmeskills.person.jacket.PumaJacket;
import by.teachmeskills.person.jacket.ZaraJacket;
import by.teachmeskills.person.pants.AdidasPants;
import by.teachmeskills.person.pants.ZaraPants;
import by.teachmeskills.person.shoes.AdidasShoes;
import by.teachmeskills.person.shoes.PumaShoes;
import by.teachmeskills.person.shoes.ZaraShoes;

import java.util.ArrayList;

public class PersonMain {
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person(new AdidasShoes(1), new ZaraPants(3), new PumaJacket(5)));
        persons.add(new Person(new PumaShoes(4), new AdidasPants(5), new ZaraJacket(9)));
        persons.add(new Person(new ZaraShoes(8), new ZaraPants(3), new PumaJacket(5)));
        int max = 0;
        int indexMax = 0;
        for (int i = 0; i < persons.size(); i++) {
            max = persons.get(i).getPrice();
            indexMax = i;
            persons.get(i).putOn();
            System.out.println();
            persons.get(i).takeOff();
            System.out.println();
        }
        System.out.println("Самый дорогой костюм стоит " + max + ", наденем его");
        System.out.println();
        persons.get(indexMax).putOn();
    }
}
