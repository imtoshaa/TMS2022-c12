package by.tms.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static by.tms.utils.Constants.constantsFlowerList;

@Getter
public class Bouquet {
    private ArrayList<String> bouquetList;

    public void addFlowerToBouquet(String... string) {
        bouquetList = new ArrayList<>(List.of(string));
        bouquetList.add("стоимость букета = " + calculatePrice());
        //ну я только так придумал, как вывести стоимость букета, ибо вы сказали удалить в FlowerMarket объект Bouquet и
        //поместить его в метод getBouquet
    }

    public int calculatePrice() {
        int price = 0;
        for (int i = 0; i < bouquetList.size(); i++) {
            Iterator<String> iterator = constantsFlowerList.keySet().iterator();
            while (iterator.hasNext()) {
                String str = iterator.next();
                if (bouquetList.get(i).equals(str)) {
                    price += constantsFlowerList.get(str);
                }
            }
        }
        return price;
    }

}
