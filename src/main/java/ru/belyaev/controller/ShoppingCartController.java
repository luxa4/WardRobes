package ru.belyaev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;
import ru.belyaev.service.ShoppingCartService;
import ru.belyaev.constant.SessionConstant;
import ru.belyaev.util.SessionUtil;

import javax.servlet.http.HttpSession;

@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingCart")
    public String showShoppingCart(Model model, HttpSession session) {
        User user = SessionUtil.getCurrentUser(session);
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUser(user);
        model.addAttribute(SessionConstant.SHOPPING_CART.toString(), shoppingCart);
        return "shoppingCartPage";
    }
}
