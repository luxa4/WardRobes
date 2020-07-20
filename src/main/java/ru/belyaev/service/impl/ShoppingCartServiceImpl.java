package ru.belyaev.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belyaev.entity.Product;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.ShoppingCartItem;
import ru.belyaev.entity.User;
import ru.belyaev.repository.ProductRepository;
import ru.belyaev.repository.ShoppingCartItemRepository;
import ru.belyaev.repository.ShoppingCartRepository;
import ru.belyaev.repository.UserRepository;
import ru.belyaev.service.ShoppingCartService;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    public static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartService.class);

    @Autowired
    UserRepository userRepository;

    @Autowired
    ShoppingCartItemRepository shoppingCartItemRepository;

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    HttpSession session;

    ShoppingCart shoppingCart;

    List<ShoppingCartItem> list;

    @Autowired
    ProductRepository productRepository;


    @Override
    @Transactional
    public void addToShoppingCart(int productId, int count) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findUserByName(name);

        Product productToCart = productRepository.findProductById(productId);
        LOGGER.info("--->>> Найден продукт - {} в количестве - {}", productToCart.getName(), count);

        LOGGER.info("--->>> Ищем корзину .... ");
        shoppingCart = shoppingCartRepository.findShoppingCartByUser(user);


        if(shoppingCart == null) {
            LOGGER.info("--->>> Корзина не найдена, создаем новую...");
            shoppingCart = new ShoppingCart();
            shoppingCart.setUser(user);
            LOGGER.info("--->>> Пользователь корзины c id - {}", shoppingCart.getUser().getId());
            shoppingCartRepository.saveAndFlush(shoppingCart);
            LOGGER.info("--->>> Сохранили корзину в базе");
        }

        ShoppingCartItem existProductInShoppingCart = shoppingCartItemRepository.findShoppingCartItemByShoppingCartAndProduct(shoppingCart, productToCart);

        if (existProductInShoppingCart == null) {
            LOGGER.info("--->>> Данного продукта в корзине еще не было, добавляем как новый");
            ShoppingCartItem shoppingCartItem = new ShoppingCartItem();
            shoppingCartItem.setProduct(productToCart);
            shoppingCartItem.setShoppingCart(shoppingCart);
            shoppingCartItem.setCount(count);
            shoppingCartItemRepository.save(shoppingCartItem);
            LOGGER.info("--->>> Добавили товар в корзину");
        } else {
            LOGGER.info("--->>> Данный продукт в корзине уже был, обновляем кол-во");
            existProductInShoppingCart.setCount(existProductInShoppingCart.getCount() + count);
            shoppingCartItemRepository.saveAndFlush(existProductInShoppingCart);
            LOGGER.info("--->>> Обновили товар в корзине");
        }

//        shoppingCart = shoppingCartRepository.findShoppingCartByUser(user);
////
//        refreshTotalCount(shoppingCart);
////        refreshTotalCost(shoppingCart);
////
////        LOGGER.info("Общее кол-во - {}", shoppingCart.getTotalCount());
////        LOGGER.info("Общая стоимость - {}", shoppingCart.getTotalCost());
    }


    @Override
    @Transactional
    public void removeFromShoppingCart(int productId, int count) {

        Product product = productRepository.findProductById(productId);

        ShoppingCartItem existProductInShoppingCart = shoppingCartItemRepository.findShoppingCartItemByShoppingCartAndProduct(shoppingCart, product);

        if (existProductInShoppingCart != null) {
            if (existProductInShoppingCart.getCount() <= count) {
                shoppingCart.getShoppingCartItems().remove(existProductInShoppingCart);
            } else {
                shoppingCart.getShoppingCartItems().get(existProductInShoppingCart.getProduct().getId()).
                        setCount(shoppingCart.getShoppingCartItems().get(existProductInShoppingCart.getProduct().getId()).getCount()-count);
            }
            shoppingCartItemRepository.save(existProductInShoppingCart);
        } else {
            existProductInShoppingCart.setCount(existProductInShoppingCart.getCount() + count);
            shoppingCartItemRepository.save(existProductInShoppingCart);
        }

//        refreshTotalCost(shoppingCart);
//        refreshTotalCount(shoppingCart);
    }

    public void refreshTotalCount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findUserByName(name);
        shoppingCart = shoppingCartRepository.findShoppingCartByUser(user);
        list = shoppingCartItemRepository.getShoppingCartItemByShoppingCart(shoppingCart);
        int totalCount = 0;
        for(ShoppingCartItem item: list) {
            totalCount = totalCount + item.getCount();
        }
        shoppingCart.setTotalCount(totalCount);
        LOGGER.info("Общее кол-во - {}", shoppingCart.getTotalCount());

    }

    public void refreshTotalCost() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        User user = userRepository.findUserByName(name);
        shoppingCart = shoppingCartRepository.findShoppingCartByUser(user);
        list = shoppingCartItemRepository.getShoppingCartItemByShoppingCart(shoppingCart);
        BigDecimal totalCost = BigDecimal.valueOf(0.00);
        for(ShoppingCartItem item: list) {
            totalCost = totalCost.add(item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getCount())));
        }
        shoppingCart.setTotalCost(totalCost);
        LOGGER.info("Общая стоимость - {}", shoppingCart.getTotalCost());
    }

}
