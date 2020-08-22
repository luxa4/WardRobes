/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 14:48
 */


package ru.belyaev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.belyaev.entity.Product;
import ru.belyaev.entity.ShoppingCart;
import ru.belyaev.entity.User;
import ru.belyaev.service.ProductService;
import ru.belyaev.service.ShoppingCartService;
import ru.belyaev.service.UserService;
import ru.belyaev.constant.SessionConstant;
import ru.belyaev.util.SessionUtil;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductController {

    public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/")
    public String showAllProduct(Model model, HttpSession session) {
        User user = userService.getUser();
        List<Product> productList = productService.listAllProducts();
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartByUser(user);
        model.addAttribute(SessionConstant.PRODUCT_LIST.toString(), productList);
        SessionUtil.setCurrentShoppingCart(session, shoppingCart);
        SessionUtil.setCurrentUser(session, user);
        return "home";
    }

    @GetMapping("/product/{productId}")
    public String showPersonalProductPage(@PathVariable int productId, Model model) {
        Product product = productService.showProductPageByProductId(productId);
        model.addAttribute(SessionConstant.PRODUCT.toString(), product);
        return "oneProductPage";
    }




}
