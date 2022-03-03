package hw5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Car {

    private String brand;
    private int maxSpeed;
    private int price;

    @Override
    public String toString() {
        return "Это автомобиль " +
                "марки " + brand + ". " +
                "Максимальная скорость составляет " + maxSpeed + " км/ч. " +
                "Цена " + price + " $.";
    }
}

