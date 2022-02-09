package by.tms.service;

import by.tms.model.Bouquet;
import by.tms.model.FlowerMarket;

import static by.tms.utils.Constants.*;

public class FlowerMain {

    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, HERBERA, LILY, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(HERBERA, ROSE, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, HERBERA, LILY, ASTER, TULIP, ASTER, ROSE));
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, CARNATION, LILY, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Количество = " + flowerMarket.getCount());
        System.out.println("Стоимость букетов составила " + flowerMarket.getPrice() + " рублей");
    }
}
