package by.tms.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Bouquet {
    private ArrayList<String> bouquetList;

    public void addFlowerToBouquet(String... string) {
        bouquetList = new ArrayList<>(List.of(string));
    }
}
