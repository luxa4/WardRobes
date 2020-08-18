/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 15:11
 */

package ru.belyaev.service;

import ru.belyaev.entity.Address;
import ru.belyaev.entity.Order;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;

public interface OrderService {

    Order makeOrder(Order order, User user);
}
