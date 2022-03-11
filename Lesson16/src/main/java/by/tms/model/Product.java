package by.tms.model;

import lombok.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Product {

    private long id;
    private String name;
    private double price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
