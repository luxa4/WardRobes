/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 15:06
 */

package ru.belyaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belyaev.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    Product findProductByNameContains(String fragmentName);

    Product findProductById(int id);
}
