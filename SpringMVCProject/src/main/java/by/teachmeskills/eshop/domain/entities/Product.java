package by.teachmeskills.eshop.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.sql.ResultSet;
import java.sql.SQLException;

import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORY_ID;
import static by.teachmeskills.eshop.utils.EshopConstants.DESCRIPTION;
import static by.teachmeskills.eshop.utils.EshopConstants.ID;
import static by.teachmeskills.eshop.utils.EshopConstants.IMG;
import static by.teachmeskills.eshop.utils.EshopConstants.NAME;
import static by.teachmeskills.eshop.utils.EshopConstants.PRICE;

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
            int id = rs.getInt(ID);
            String name = rs.getString(NAME);
            String description = rs.getString(DESCRIPTION);
            String img = rs.getString(IMG);
            int price = rs.getInt(PRICE);
            int categoryId = rs.getInt(CATEGORY_ID);
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
