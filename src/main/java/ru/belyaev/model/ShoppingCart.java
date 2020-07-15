/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 14:52
 */


package ru.belyaev.model;

import ru.belyaev.entity.User;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total_count")
    private int totalCount;

    @Column(name = "total_cost")
    private BigDecimal totalCost;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart", cascade = CascadeType.REFRESH)
    List<ShoppingCartItem> shoppingCartItems;

    @OneToOne
    @JoinColumn(name = "id_user")
    private User user;

    private void refreshTotalCount(){
        totalCount = 0;
        for(ShoppingCartItem item: shoppingCartItems) {
            totalCount = totalCount + item.getCount();
        }
    }

    private void refreshTotalCost() {
        totalCost = BigDecimal.valueOf(0.00);
        for(ShoppingCartItem item: shoppingCartItems) {
            totalCost = totalCost.add(item.getPrice());
        }
    }

    public void addToShoppingCart() {

        refreshTotalCost();
        refreshTotalCount();
    }

    public void removeFromShoppingCart() {

        refreshTotalCost();
        refreshTotalCount();
    }

}
