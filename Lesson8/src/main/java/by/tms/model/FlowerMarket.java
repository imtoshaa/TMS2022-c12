package by.tms.model;

import static by.tms.utils.Constants.*;
import java.util.ArrayList;

public class FlowerMarket {
    Bouquet bouquet = new Bouquet();
    private int count;
    private int price;

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public ArrayList<String> getBouquet(String... string) {
        bouquet.addFlowerToBouquet(string);
        findFlowerByName();
        return bouquet.getBouquetList();
    }

    private void findFlowerByName() {
        for (int i = 0; i < bouquet.getBouquetList().size(); i++) {
            for (int j = 0; j < constantsFlowerList.size(); j++) {
                if (bouquet.getBouquetList().get(i).equals(constantsFlowerList.get(j).getName())) { //не заходит, хотя это стринги, а там equels присутствует ведь
                    calculatingThePrice(constantsFlowerList.get(j));
                    calculatingTheCount();
                }

            }
        }
    }

    private void calculatingThePrice(Flower flower) {
        price += flower.getCost();
    }

    private void calculatingTheCount() {
        count++;
    }
}
