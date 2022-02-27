package by.teachmeskills.person.model;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
public class Person implements IPerson {
    private final String namePerson;
    private final List<Clothes> clothes;


    @Override
    public void takeOff() {
        for (Clothes clothe : clothes) {
            if (clothe.isOn()) {
                System.out.println(clothe.getType().getName() + " " + clothe.getBrand().getName() + " снята");
                clothe.setOn(false);
            }
        }
    }

    @Override
    public BigDecimal getPrice() {
        return clothes.stream().map(Clothes::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    @Override
    public void putOn() {
        for (Clothes clothe : clothes) {
            if (!clothe.isOn()) {
                System.out.println(clothe.getType().getName() + " " + clothe.getBrand().getName() + " надета");
                clothe.setOn(true);

            }
        }
    }
}
