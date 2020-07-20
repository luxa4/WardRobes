package ru.belyaev.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belyaev.entity.Product;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.ShoppingCartItem;

import java.util.List;

@Repository
public interface ShoppingCartItemRepository extends JpaRepository<ShoppingCartItem, Long> {

    List<ShoppingCartItem> getShoppingCartItemByShoppingCart(ShoppingCart shoppingCart);

    ShoppingCartItem findShoppingCartItemByShoppingCartAndProduct(ShoppingCart shoppingCart, Product product);

}
