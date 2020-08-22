package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.belyaev.entity.Order;
import ru.belyaev.entity.User;
import ru.belyaev.service.OrderService;
import ru.belyaev.constant.SessionConstant;

import javax.servlet.http.HttpSession;
import java.util.List;

import static ru.belyaev.constant.SessionConstant.USER;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public String showUserOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute(USER.toString());
        List<Order> orders = orderService.findUserOrders(user);
        long countOrders = orderService.findCountUserOrders(user);
        model.addAttribute(SessionConstant.ORDER_LIST.toString(), orders);
        model.addAttribute(SessionConstant.COUNT_ORDERS.toString(), countOrders);
        return "ordersPage";
    }

    @GetMapping("/orders/{orderId}")
    public String showOneUserOrder(@PathVariable long orderId, Model model) {
        Order order = orderService.findOrderById(orderId);
        model.addAttribute(SessionConstant.ORDER.toString(), order);
        return "orderPage";
    }
}
