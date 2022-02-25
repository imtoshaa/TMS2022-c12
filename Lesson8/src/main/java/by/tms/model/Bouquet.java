package by.tms.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@AllArgsConstructor
@ToString
public class Bouquet {
    private ArrayList<Flower> flowers;

    public int getCostBouquet() {
        int cost = 0;
        for (Flower flower : flowers) {
            cost += flower.getCost();
        }
        return cost;
    }
}
