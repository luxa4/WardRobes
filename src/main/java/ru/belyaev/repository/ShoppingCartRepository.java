package ru.belyaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.ShoppingCartItem;
import ru.belyaev.entity.User;

import java.util.List;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    ShoppingCart findShoppingCartByUser(User user);
}
