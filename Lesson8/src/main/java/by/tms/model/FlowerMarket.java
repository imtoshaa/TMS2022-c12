package by.tms.model;

import lombok.Getter;

import static by.tms.utils.Constants.*;

import java.util.ArrayList;
import java.util.Iterator;
@Getter
public class FlowerMarket {
    private int count;
    private int cost;
    public Bouquet getBouquet(String... flowers) {
        ArrayList<Flower> flowerArrayList = new ArrayList<>();
        for (String string : flowers) {
            Iterator<String> iterator = NAME_PRICE_FLOWERS.keySet().iterator();
            while (iterator.hasNext()) {
                String iter = iterator.next();
                if (iter.equals(string)) {
                    flowerArrayList.add(new Flower(string, NAME_PRICE_FLOWERS.get(iter)));
                    count++;
                }
            }
        }
        Bouquet bouquet = new Bouquet(flowerArrayList);
        cost = bouquet.getCostBouquet();
        return bouquet;
    }

}
