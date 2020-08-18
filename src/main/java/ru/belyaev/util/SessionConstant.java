package ru.belyaev.util;

public enum SessionConstant {
    SHOPPING_CART("shopping_cart"), USER("user"), ORDER("order"), PRODUCT("product"),
    MIN_LEN("lenMin"), MAX_LEN("lenMax"),
    MIN_WID("widMin"), MAX_WID("widMax"),
    MIN_HEI("heiMin"), MAX_HEI("heiMax"),
    MIN_PRICE("priceMin"), MAX_PRICE("priceMax");

    private String title;

    SessionConstant(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getTitle();
    }
}
