package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Flower {
    private String name;
    private int cost;

    public Flower(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }
}
