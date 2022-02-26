package by.teachmeskills.person;

import by.teachmeskills.person.utils.Brand;
import by.teachmeskills.person.utils.ClothesType;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
public abstract class Clothes implements ClothesAware {


    private final BigDecimal price;
    private boolean isOn;
    private ClothesType type;
    private final Brand brandName;

    public Clothes(BigDecimal price, Brand brandName) {
        this.price = price;
        this.brandName = brandName;
    }

    public void setType(ClothesType type) {
        //думаю ничего опасного нет, если я буду через этот сеттер из конструктора наследника
        //передавать значение type в родителя, так как родитель является абстрактом
        this.type = type;
    }

    @Override
    public void putOn() {
        if (!isOn) {
            System.out.println(type.getName() + " " + brandName.getName() + " надета");
            isOn = true;
        }
    }

    @Override
    public void takeOff() {
        if (isOn) {
            System.out.println(type.getName() + " " + brandName.getName() + " снята");
            isOn = false;
        }
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }
}
