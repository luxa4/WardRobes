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

import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Long countAllProduct() {
        return productRepository.count();
    }

    @Override
    public List<Product> listAllProducts() {
        List<Product> products = productRepository.findAll();
        return products;
    }

    @Override
    public BigDecimal showMaxHeight() {
        return productRepository.findMaxHeight();
    }

    @Override
    public BigDecimal showMinHeight() {
        return productRepository.findMinHeight();
    }

    @Override
    public BigDecimal showMaxWidth() {
        return productRepository.findMaxWidth();
    }

    @Override
    public BigDecimal showMinWidth() {
        return productRepository.findMinWidth();
    }

    @Override
    public BigDecimal showMaxLength() {
        return productRepository.findMaxLength();
    }

    @Override
    public BigDecimal showMinLength() {
        return productRepository.findMinLength();
    }

    @Override
    public BigDecimal showMaxPrice() {
        return productRepository.findMaxPrice();
    }

    @Override
    public BigDecimal showMinPrice() {
        return productRepository.findMinPrice();
    }

    @Override
    public Product showProductPageByProductId(int id) {
        Product product = productRepository.findProductById(id);
        return product;
    }

    @Override
    public List<Product> productBySearchFilter(BigDecimal minLen, BigDecimal maxLen, BigDecimal minWidth,
                                               BigDecimal maxWidth, BigDecimal minHeight, BigDecimal maxHeight,
                                               BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.searchFilters(minLen, maxLen, minWidth, maxWidth, minHeight, maxHeight,
                minPrice, maxPrice);
    }

    @Override
    public int countProductBySearchFilter(BigDecimal minLen, BigDecimal maxLen, BigDecimal minWidth,
                                          BigDecimal maxWidth, BigDecimal minHeight, BigDecimal maxHeight,
                                          BigDecimal minPrice, BigDecimal maxPrice) {
        return productRepository.searchFiltersCount(minLen, maxLen, minWidth, maxWidth, minHeight, maxHeight,
                minPrice, maxPrice);
    }

    @Override
    public List<Product> findProductForSearchTextForm(String fragment) {
        List<Product> products = productRepository.findProductsByNameContainingIgnoreCase(fragment);
        return products;
    }

    @Override
    public long countProductForSearchTextForm(String fragment) {
        return productRepository.countProductByNameContainingIgnoreCase(fragment);
    }
}
