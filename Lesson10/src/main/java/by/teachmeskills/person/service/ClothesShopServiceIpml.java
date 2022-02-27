package by.teachmeskills.person.service;

import by.teachmeskills.person.model.IPerson;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;


@Getter
public class ClothesShopServiceIpml implements ClothesShopService{

    private final List<IPerson> personList;
    private int indexMax;

    public ClothesShopServiceIpml(List<IPerson> personList) {
        this.personList = personList;
    }

    @Override
    public void putOn() {
        for (IPerson person : personList) {
            person.putOn();
            System.out.println();
        }
    }

    @Override
    public void putOnWithMaxPrice() {
        System.out.println("Самый дорогой костюм стоит " + getClothesWithMaxPrice() + ", наденем его");
        personList.get(indexMax).putOn();
        System.out.println();
    }

    @Override
    public void takeOff() {
        for (IPerson person : personList) {
            person.takeOff();
            System.out.println();
        }
    }

    @Override
    public BigDecimal getClothesWithMaxPrice() {
        BigDecimal max = BigDecimal.ZERO;
        IPerson person;
        for (int i = 0; i < personList.size(); i++) {
            person = personList.get(i);
            if (max.compareTo(person.getPrice()) <= 0) {
                max = person.getPrice();
                indexMax = i;
            }
        }
        return max;
    }
}
