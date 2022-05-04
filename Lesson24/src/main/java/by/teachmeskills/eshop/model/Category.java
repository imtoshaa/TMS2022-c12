package by.teachmeskills.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class Category {
    private String id;
    private String name;
    private String img;
    private String description;
    private List<Product> productList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(img, category.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, img);
    }
}
