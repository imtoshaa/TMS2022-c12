package by.teachmeskills.eshop;

public enum PagesPathEnum {
    HOME_PAGE("home.jsp"),
    SIGN_IN_PAGE("signin.jsp"),
    CATEGORY_PAGE("category.jsp"),
    CART_PAGE("cart.jsp"),
    MY_PAGE("mypage.jsp"),
    REGISTRATION_PAGE("registration.jsp"),
    SEARCH_PAGE("search.jsp"),
    PRODUCT_PAGE("product.jsp");

    private final String path;

    PagesPathEnum(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}

