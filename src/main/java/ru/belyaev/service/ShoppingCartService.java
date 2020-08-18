package ru.belyaev.service;

import ru.belyaev.entity.Product;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;

import javax.servlet.http.HttpSession;

public interface ShoppingCartService {

    ShoppingCart addToShoppingCart(int productId, int count);

    ShoppingCart removeFromShoppingCart(int productId, int count);

    void removeShoppingCart(ShoppingCart shoppingCart, HttpSession session);

    ShoppingCart getUserShoppingCart();


}
