/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 14:52
 */


package ru.belyaev.model;

import java.math.BigDecimal;

public class ShoppingCartItem {

    private int count;

    private BigDecimal price;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
