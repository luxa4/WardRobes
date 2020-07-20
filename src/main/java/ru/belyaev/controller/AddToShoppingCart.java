/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 14:47
 */


package ru.belyaev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.belyaev.service.ShoppingCartService;

@Controller
public class AddToShoppingCart {

    public static final Logger LOGGER = LoggerFactory.getLogger(AddToShoppingCart.class);

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/addToShoppingCart/{productId}")
    public String addToShoppingCart(@PathVariable int productId, @RequestParam("count") int count)  {
        shoppingCartService.addToShoppingCart(productId, count);
        shoppingCartService.refreshTotalCost();
        shoppingCartService.refreshTotalCount();
        LOGGER.info("->>>> Конец работы контроллера");
        return "redirect:/";
    }

}
