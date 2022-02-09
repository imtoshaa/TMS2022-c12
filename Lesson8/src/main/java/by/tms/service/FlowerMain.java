package by.tms.service;

import by.tms.model.Bouquet;
import by.tms.model.FlowerMarket;

import static by.tms.utils.Constants.*;

public class FlowerMain {

    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, HERBERA, LILY, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Из количества цветов = " + flowerMarket.getCount());
        System.out.println("Стоимость букета составила " + flowerMarket.getPrice() + " рублей");
    }
}
