/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 14:47
 */


package ru.belyaev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddToShoppingCart {

    @GetMapping("/addToShoppingCart/{productId}")
    public void addToShoppingCart(@PathVariable int productId, @RequestParam("count") int count)  {


    }

}
