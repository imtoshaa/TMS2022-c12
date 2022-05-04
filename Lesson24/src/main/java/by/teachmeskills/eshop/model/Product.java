package by.teachmeskills.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@EqualsAndHashCode
public class Product {
    private int id;
    private String name;
    private String description;
    private int price;
    private String img;
}
