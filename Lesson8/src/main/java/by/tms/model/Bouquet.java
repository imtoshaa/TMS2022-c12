package by.tms.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static by.tms.utils.Constants.NAME_PRICE_FLOWERS;

@Getter
public class Bouquet {
    private ArrayList<Flower> bouquetList = new ArrayList<>();

    public Bouquet(ArrayList<Flower> flowers) {
        this.bouquetList.addAll(flowers);
    }

    public int getCostBouquet() {
        int cost = 0;
        for (int i = 0; i < bouquetList.size(); i++) {
            cost += bouquetList.get(i).getCost();
        }
        return cost;
    }

    @Override
    public String toString() {
        return bouquetList.toString();
    }
}
