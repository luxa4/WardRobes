package ru.belyaev.controller.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.model.JsonCart;
import ru.belyaev.service.ShoppingCartService;
import ru.belyaev.util.SessionConstant;

import javax.servlet.http.HttpSession;

@RestController
public class RemoveFromShoppingCartController {

    public static final Logger LOGGER = LoggerFactory.getLogger(RemoveFromShoppingCartController.class);

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping(value = "/removeFromShoppingCart")
    public JsonCart deleteProductFromShoppingCart(@RequestParam("productId") int productId, @RequestParam("count") int count, HttpSession session) {
        ShoppingCart shoppingCart = shoppingCartService.removeFromShoppingCart(productId, count);
        session.setAttribute(SessionConstant.SHOPPING_CART.toString(), shoppingCart);
        JsonCart jsonCart = new JsonCart(shoppingCart.getTotalCount(), shoppingCart.getTotalCost());
        return jsonCart;
    }
}
