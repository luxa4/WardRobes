/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 12:55
 */

package ru.belyaev.service;

import ru.belyaev.entity.Product;

import java.util.List;

public interface ProductService {

    Integer countAllProduct();

    List<Product> listAllProducts();

    Product showProductPageByProductId(int id);

}
