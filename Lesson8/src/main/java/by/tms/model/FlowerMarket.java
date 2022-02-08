package by.tms.model;

import java.util.ArrayList;
import java.util.List;

public class FlowerMarket {
    private ArrayList<Flower> listFlower = new ArrayList<>();
    public int count = 0;

    public void addFlowerToList(Flower flower) {
        listFlower.add(flower);
    }

    public void getBouquet(String... bouquet) {
        int cost = 0;
        ArrayList<String> bouquetList = new ArrayList<String>(List.of(bouquet));
        for (int i = 0; i < bouquetList.size(); i++) {
            for (int j = 0; j < listFlower.size(); j++) {
                if (nameVerification(bouquetList.get(i), listFlower.get(j).getName())) {
                    count++;
                    cost += listFlower.get(j).getCost();
                }
            }
        }
        System.out.println(bouquetList.toString());
        System.out.println("Букет готов! С вас " + cost + " рублей.");
    }

    private boolean nameVerification(String flowerFromBouquet, String flower) {
        if (flowerFromBouquet.equals(flower)) {
            return true;
        }
        return false;
    }
}
