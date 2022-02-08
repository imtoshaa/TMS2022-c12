package by.tms.service;

import by.tms.model.Flower;
import by.tms.model.FlowerMarket;
import by.tms.utils.Constants;

public class FlowerMain {
    FlowerMarket flowerMarket = new FlowerMarket();

    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        Constants constants = new Constants();
        flowerMarket.addFlowerToList(new Flower(constants.ASTER, 1));
        flowerMarket.addFlowerToList(new Flower(constants.CARNATION, 4));
        flowerMarket.addFlowerToList(new Flower(constants.LILY, 2));
        flowerMarket.addFlowerToList(new Flower(constants.HERBERA, 3));
        flowerMarket.addFlowerToList(new Flower(constants.ROSE, 8));
        flowerMarket.addFlowerToList(new Flower(constants.TULIP, 6));
        flowerMarket.getBouquet(constants.ASTER, constants.ASTER, constants.CARNATION, constants.ROSE, constants.ROSE);
        flowerMarket.getBouquet(constants.ROSE, constants.ROSE, constants.ROSE);
        flowerMarket.getBouquet(constants.ASTER, constants.HERBERA, constants.TULIP, constants.ROSE, constants.ROSE, constants.ROSE);
        flowerMarket.getBouquet(constants.HERBERA, constants.LILY, constants.LILY, constants.ASTER, constants.CARNATION);
        flowerMarket.getBouquet(constants.CARNATION, constants.ASTER, constants.CARNATION);
        System.out.println("Всего цветов продано " + flowerMarket.count);
    }
}
