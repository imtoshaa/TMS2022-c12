package by.teachmeskills.eshop;

public enum RequestParamsEnum {
    USERNAME("username"),
    PASSWORD("password"),
    USER("user"),
    COMMAND("command"),
    SHOPPING_CART("cart"),

    CATEGORY("category"),
    CATEGORIES("categories"),
    CATEGORY_ID("categoryId"),

    PRODUCT("product"),
    PRODUCTS("products"),
    SHOPPING_CART_PRODUCTS("cartProductsList"),
    ORDER_HISTORY("orderHistory"),
    PRODUCTS_FROM_CATEGORY("productsFromCategory"),
    PRODUCTS_FROM_SEARCH("productsFromSearch"),
    SEARCH_QUERY("searchQuery"),
    PRODUCT_ID("productId");

    private final String value;

    RequestParamsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

