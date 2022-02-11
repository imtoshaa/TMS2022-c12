package by.tms.service;

import by.tms.model.Bouquet;
import by.tms.model.FlowerMarket;

import static by.tms.utils.Constants.*;

public class FlowerMain {

    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();

        Bouquet bouquet = flowerMarket.getBouquet(ROSE, ROSE, HERBERA, LILY, ASTER, TULIP, ASTER, CARNATION);
        System.out.println("Сформирован следующий букет: " + bouquet);
        System.out.println("Цена букета в рублях = " + bouquet.getCostBouquet());

        Bouquet bouquet1 = flowerMarket.getBouquet(HERBERA, ROSE, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION);
        System.out.println("Сформирован следующий букет: " + bouquet1);
        System.out.println("Цена букета в рублях = " + bouquet1.getCostBouquet());

        Bouquet bouquet2 = flowerMarket.getBouquet(ROSE, ROSE, CARNATION, LILY, ASTER, TULIP, ASTER, CARNATION);
        System.out.println("Сформирован следующий букет: " + bouquet2);
        System.out.println("Цена букета в рублях = " + bouquet2.getCostBouquet());

        Bouquet bouquet3 = flowerMarket.getBouquet(ROSE, HERBERA, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION);
        System.out.println("Сформирован следующий букет: " + bouquet3);
        System.out.println("Цена букета в рублях = " + bouquet3.getCostBouquet());

        Bouquet bouquet4 = flowerMarket.getBouquet(ROSE, HERBERA, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION);
        System.out.println("Сформирован следующий букет: " + bouquet4);
        System.out.println("Цена букета в рублях = " + bouquet4.getCostBouquet());

        System.out.println("Стоимость всех букетов в рублях = " + flowerMarket.getCost());
        System.out.println("Количество проданых цветов = " + flowerMarket.getCount());
    }
}
