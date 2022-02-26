package com.tms.clothes;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Getter
public abstract class Clothes {
    private int size;
    private int cost;
    private String color;
}
