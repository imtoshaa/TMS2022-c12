package by.teachmeskills.eshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.sql.ResultSet;
import java.sql.SQLException;

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
            return Product.builder()
                    .id(id)
                    .name(name)
                    .description(description)
                    .price(price)
                    .img(img)
                    .build();
        }
    }
}
