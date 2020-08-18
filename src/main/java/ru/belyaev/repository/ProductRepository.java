/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 15:06
 */

package ru.belyaev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.belyaev.entity.Product;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    long count();

    List<Product> findAll();

    Product findProductByNameContains(String fragmentName);

    Product findProductById(int id);

    // For filters
    BigDecimal findMaxHeight();
    BigDecimal findMinHeight();
    BigDecimal findMaxLength();
    BigDecimal findMinLength();
    BigDecimal findMaxWidth();
    BigDecimal findMinWidth();
    BigDecimal findMaxPrice();
    BigDecimal findMinPrice();

    List<Product> searchFilters(BigDecimal minLen, BigDecimal maxLen, BigDecimal minWidth, BigDecimal maxWidth,
                                BigDecimal minHeight, BigDecimal maxHeight, BigDecimal minPrice, BigDecimal maxPrice);

    int searchFiltersCount(BigDecimal minLen, BigDecimal maxLen, BigDecimal minWidth, BigDecimal maxWidth,
                                BigDecimal minHeight, BigDecimal maxHeight, BigDecimal minPrice, BigDecimal maxPrice);

}
