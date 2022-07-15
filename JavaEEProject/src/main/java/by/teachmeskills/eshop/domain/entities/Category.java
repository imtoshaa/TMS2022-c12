package by.teachmeskills.eshop.domain.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@ToString
@SuperBuilder
@AllArgsConstructor
@EqualsAndHashCode
public class Category extends BaseEntity {
    private String name;
    private String img;
    private String description;
    private List<Product> productList;
}
