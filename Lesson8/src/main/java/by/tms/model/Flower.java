package by.tms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Flower {
    private String name;
    private int cost;

    public Flower(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
