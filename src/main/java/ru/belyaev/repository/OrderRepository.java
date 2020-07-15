/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 15:10
 */

package ru.belyaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belyaev.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Order findOrderById(int id);
}
