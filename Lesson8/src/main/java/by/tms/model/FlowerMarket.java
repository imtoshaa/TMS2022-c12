package by.tms.model;

import java.util.ArrayList;

import static by.tms.utils.Constants.NAME_PRICE_FLOWERS;

//@Getter
//если я создаю @Getter тут на все поля, то у меня ломается программа, выводит, что цена букета равно нулю
//если создаю руками, то всё ок
//а если я сначала запускаю c аннотацией Getter, а потом запускаю с созданными геттерами вручную, то всё равно ломается. нужно чистить таргет
public class FlowerMarket {
    //    @Getter
    private int count;
    //    @Getter
    private int cost;
    //    @Getter
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

    public Bouquet getBouquet() {
        return bouquet;
    }

    public int getCount() {
        return count;
    }

    public int getCost() {
        return cost;
    }
}
