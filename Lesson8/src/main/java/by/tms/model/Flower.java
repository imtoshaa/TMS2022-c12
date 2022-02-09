package by.tms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

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
