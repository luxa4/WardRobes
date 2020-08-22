package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.belyaev.entity.Product;
import ru.belyaev.service.ProductService;

import java.util.List;

@Controller
public class SearchTextController {

    @Autowired
    private ProductService productService;

    @GetMapping("/searchProduct")
    public String showSearchResult(Model model, @RequestParam(value = "fragment") String fragment) {
        List<Product> productList = productService.findProductForSearchTextForm(fragment);
        long count = productService.countProductForSearchTextForm(fragment);
        model.addAttribute("productList", productList);
        model.addAttribute("countProduct", count);
        return "home";
    }
}
