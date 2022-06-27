package by.teachmeskills.eshop;

public enum RequestParamsEnum {
    USERNAME("username"),
    PASSWORD("password"),
    USER("user"),
    COMMAND("command"),
    SHOPPING_CART("cart"),

    CATEGORY("category"),
    CATEGORIES("categories"),
    CATEGORY_NAME("categoryName"),

    PRODUCT("product"),
    PRODUCTS("products"),
    SHOPPING_CART_PRODUCTS("cartProductsList"),
    PRODUCT_ID("productId");

    private final String value;

    RequestParamsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

