package by.tms.service;

import by.tms.model.FlowerMarket;

import static by.tms.utils.Constants.*;

public class FlowerMain {

    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, HERBERA, LILY, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Цена букета в рублях = " + flowerMarket.getBouquet().getCostBouquet()); //полиморфм

        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(HERBERA, ROSE, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Цена букета в рублях = " + flowerMarket.getBouquet().getCostBouquet());

        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, CARNATION, LILY, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Цена букета в рублях = " + flowerMarket.getBouquet().getCostBouquet());

        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, HERBERA, HERBERA, ASTER, ASTER, TULIP, ASTER, CARNATION));
        System.out.println("Цена букета в рублях = " + flowerMarket.getBouquet().getCostBouquet());

        System.out.println("Сформирован следующий букет: " + flowerMarket.getBouquet(ROSE, ROSE, HERBERA, LILY, TULIP, TULIP, ASTER, ROSE));
        System.out.println("Цена букета в рублях = " + flowerMarket.getBouquet().getCostBouquet());

        System.out.println("Стоимость всех букетов в рублях = " + flowerMarket.getCost());
        System.out.println("Количество проданых цветов = " + flowerMarket.getCount());
    }
}
