/*
 * Created by Vologda Developer
 * Date: 25.06.2020
 * Time: 14:48
 */


package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.belyaev.entity.Product;
import ru.belyaev.service.ProductService;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String showAllProduct(Model model) {
        List<Product> productList = productService.listAllProducts();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/product/{productId}")
    public String showPersonalProductPage(@PathVariable int productId, Model model) {
        Product product = productService.showProductPageByProductId(productId);
        model.addAttribute("product", product);
        return "oneProductPage";
    }


}
