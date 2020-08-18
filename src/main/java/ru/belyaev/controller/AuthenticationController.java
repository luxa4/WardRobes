/*
 * Created by Vologda Developer
 * Date: 23.06.2020
 * Time: 11:07
 */


package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.belyaev.entity.User;
import ru.belyaev.service.UserService;

@Controller
public class AuthenticationController {

    private User user;

    @Autowired
    UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("UserFromRegistrationForm", new User());
        return "registrationForm";
    }

    @PostMapping("/registration")
    public String checkRegistrationForm(@ModelAttribute("UserFromRegistrationForm") User user) {
        userService.addUser(user);
        return "loginPage";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

}
