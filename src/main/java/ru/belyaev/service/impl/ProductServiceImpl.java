/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 12:55
 */


package ru.belyaev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.belyaev.entity.Product;
import ru.belyaev.repository.ProductRepository;
import ru.belyaev.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Integer countAllProduct() {
        return null;
    }

    @Override
    public List<Product> listAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public Product showProductPageByProductId(int id) {
        Product product = productRepository.findProductById(id);
        return product;
    }
}
