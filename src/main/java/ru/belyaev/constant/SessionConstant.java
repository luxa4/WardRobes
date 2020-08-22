package ru.belyaev.constant;

public enum SessionConstant {
    SHOPPING_CART("shoppingCart"),
    USER("user"),
    ORDER_LIST("orderList"),
    ORDER("order"),
    PRODUCT("product"),
    COUNT_PRODUCT("countProduct"),
    COUNT_PRODUCT_BY_SEARCH_FORM("countProductBySearchForm"),
    PRODUCT_LIST("productList"),
    COUNT_ORDERS("countOrders"),
    MIN_LEN("lenMin"),
    MAX_LEN("lenMax"),
    MIN_WID("widMin"),
    MAX_WID("widMax"),
    MIN_HEI("heiMin"),
    MAX_HEI("heiMax"),
    MIN_PRICE("priceMin"),
    MAX_PRICE("priceMax");

    private String title;

    SessionConstant(String title) {
        this.title = title;
    }

    private String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
