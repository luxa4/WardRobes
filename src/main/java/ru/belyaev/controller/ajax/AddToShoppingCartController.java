/*
 * Created by Vologda Developer
 * Date: 10.07.2020
 * Time: 14:47
 */


package ru.belyaev.controller.ajax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;
import ru.belyaev.model.JsonCart;
import ru.belyaev.service.ShoppingCartService;
import ru.belyaev.util.SessionUtil;

import javax.servlet.http.HttpSession;

@RestController
public class AddToShoppingCartController {

    public static final Logger LOGGER = LoggerFactory.getLogger(AddToShoppingCartController.class);

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/addToShoppingCart")
    public JsonCart addToShoppingCart(@RequestParam("productId") int productId, @RequestParam("count") int count, HttpSession session)  {
        User user = SessionUtil.getCurrentUser(session);
        ShoppingCart shoppingCart = shoppingCartService.addToShoppingCart(productId, count, user);
        SessionUtil.setCurrentShoppingCart(session, shoppingCart);
        JsonCart jsonCart = new JsonCart(shoppingCart.getTotalCount(), shoppingCart.getTotalCost());
        return jsonCart;
    }

}
