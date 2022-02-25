package by.tms.model;

import lombok.Getter;

import java.util.ArrayList;

import static by.tms.utils.Constants.NAME_PRICE_FLOWERS;

@Getter
public class FlowerMarket {
    private int count;
    private int cost;
    private Bouquet bouquet;

    public Bouquet getBouquet(String... flowers) {
        ArrayList<Flower> flowerArrayList = new ArrayList<>();
        for (String string : flowers) {
            Integer price = NAME_PRICE_FLOWERS.get(string);
            flowerArrayList.add(new Flower(string, price));
        }
        bouquet = new Bouquet(flowerArrayList);
        cost += bouquet.getCostBouquet();
        count += flowerArrayList.size();
        return bouquet;
    }
}
