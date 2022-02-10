package by.tms.model;

import static by.tms.utils.Constants.*;

import java.util.ArrayList;
import java.util.Iterator;

public class FlowerMarket {
    private int count;

    public int getCount() {
        return count;
    }

    public ArrayList<String> getBouquet(String... string) {
        Bouquet bouquet = new Bouquet();
        bouquet.addFlowerToBouquet(string);
        findFlowerByName(bouquet);
        bouquet.calculatePrice();
        return bouquet.getBouquetList();
    }

    private void findFlowerByName(Bouquet bouquet) {
        for (int i = 0; i < bouquet.getBouquetList().size(); i++) {
            Iterator<String> iterator = constantsFlowerList.keySet().iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                if (bouquet.getBouquetList().get(i).equals(str)) {
                    calculatingTheCount();
                }
            }
        }
    }

    private void calculatingTheCount() {
        count++;
    }
}
