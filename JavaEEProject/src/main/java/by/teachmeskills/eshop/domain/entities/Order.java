package by.teachmeskills.eshop.domain.entities;

import by.teachmeskills.eshop.services.impl.ProductServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.sql.ResultSet;
import java.util.Date;

@Getter
@AllArgsConstructor
@SuperBuilder
public class Order extends BaseEntity {

    private int userId;
    private String date;
    private int price;
    private int productId;
    private Product product;

    public static Order.Builder newBuilder() {
        return new Order.Builder();
    }

    public static final class Builder {

        private Builder() {
        }

        public Order buildOrderFromResultSet(ResultSet rs) throws Exception {
            int orderID = rs.getInt("ID");
            String orderDate = String.valueOf(rs.getDate("DATE"));
            int orderPrice = rs.getInt("PRICE");
            int productID = rs.getInt("PRODUCT_ID");
            int userId = rs.getInt("USER_ID");
            ProductServiceImpl productService = new ProductServiceImpl();
            Product product = productService.getProductById(productID);
            return Order.builder()
                    .id(orderID)
                    .date(orderDate)
                    .price(orderPrice)
                    .userId(userId)
                    .product(product)
                    .build();
        }
    }
}
