package by.teachmeskills.eshop.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@SuperBuilder
@AllArgsConstructor
public class Product extends BaseEntity {
    private String name;
    private String description;
    private int price;
    private String img;
    private int categoryId;

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Builder() {
        }

        public Product buildProductFromResultSet(ResultSet rs) throws SQLException {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String description = rs.getString("description");
            String img = rs.getString("img");
            int price = rs.getInt("price");
            int categoryId = rs.getInt("category_id");
            return Product.builder()
                    .id(id)
                    .name(name)
                    .description(description)
                    .price(price)
                    .img(img)
                    .categoryId(categoryId)
                    .build();
        }
    }
}
