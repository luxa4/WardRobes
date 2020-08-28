package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import ru.belyaev.entity.Order;
import ru.belyaev.entity.User;
import ru.belyaev.exception.ResourceNotFoundException;
import ru.belyaev.service.OrderService;
import ru.belyaev.constant.SessionConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        if (order == null) throw new ResourceNotFoundException("something wrong");

        model.addAttribute(SessionConstant.ORDER.toString(), order);
        return "orderPage";
    }


}
