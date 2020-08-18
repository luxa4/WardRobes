package ru.belyaev.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.service.ShoppingCartService;
import ru.belyaev.util.SessionConstant;

@Controller
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingCart")
    public String showShoppingCart(Model model) {
        ShoppingCart shoppingCart = shoppingCartService.getUserShoppingCart();
        model.addAttribute(SessionConstant.SHOPPING_CART.toString(), shoppingCart);
        return "shoppingCartPage";
    }
}
