package com.tms.jdbc.task1.model;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class Product {
    private int id;
    private String name;
    private String info;
    private double price;
    private int quantity;
    private boolean inStock;

}
