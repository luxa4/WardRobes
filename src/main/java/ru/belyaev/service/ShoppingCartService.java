package ru.belyaev.service;

import ru.belyaev.entity.Product;
import ru.belyaev.entity.User;

public interface ShoppingCartService {

    void addToShoppingCart(int productId, int count);

    void removeFromShoppingCart(int productId, int count);

    void refreshTotalCount();
    void refreshTotalCost();

}
