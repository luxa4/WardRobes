package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.belyaev.entity.User;
import ru.belyaev.service.OrderService;

import javax.servlet.http.HttpSession;

import static ru.belyaev.constant.SessionConstant.USER;

@Controller
public class UserController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/user")
    public String showUserInformation(Model model, HttpSession session) {
        User user = (User) session.getAttribute(USER.toString());
        long countOrders = orderService.findCountUserOrders(user);
        model.addAttribute("countOrders", countOrders);
        return "userPage";
    }
}
