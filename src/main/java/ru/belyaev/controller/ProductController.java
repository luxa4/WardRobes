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
import ru.belyaev.util.SessionConstant;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
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
        List<Product> productList = productService.listAllProducts();
        ShoppingCart shoppingCart = shoppingCartService.getUserShoppingCart();
        BigDecimal maxLen   = productService.showMaxLength();
        BigDecimal minLen   = productService.showMinLength();
        BigDecimal maxHei   = productService.showMaxHeight();
        BigDecimal minHei   = productService.showMinHeight();
        BigDecimal maxWid   = productService.showMaxWidth();
        BigDecimal minWid   = productService.showMinWidth();
        BigDecimal maxPrice = productService.showMaxPrice();
        BigDecimal minPrice = productService.showMinPrice();

        session.setAttribute(SessionConstant.MAX_LEN.toString(), maxLen.toPlainString());
        session.setAttribute(SessionConstant.MIN_LEN.toString(), minLen.toPlainString());
        session.setAttribute(SessionConstant.MAX_HEI.toString(), maxHei.toPlainString());
        session.setAttribute(SessionConstant.MIN_HEI.toString(), minHei.toPlainString());
        session.setAttribute(SessionConstant.MAX_WID.toString(), maxWid.toPlainString());
        session.setAttribute(SessionConstant.MIN_WID.toString(), minWid.toPlainString());
        session.setAttribute(SessionConstant.MAX_PRICE.toString(), maxPrice.toPlainString());
        session.setAttribute(SessionConstant.MIN_PRICE.toString(), minPrice.toPlainString());
        User user = userService.getUser();
        session.setAttribute(SessionConstant.USER.toString(), user);
        session.setAttribute(SessionConstant.SHOPPING_CART.toString(), shoppingCart);
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/product/{productId}")
    public String showPersonalProductPage(@PathVariable int productId, Model model) {
        Product product = productService.showProductPageByProductId(productId);
        model.addAttribute(SessionConstant.PRODUCT.toString(), product);
        return "oneProductPage";
    }




}
