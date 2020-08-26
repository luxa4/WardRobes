/*
 * Created by Vologda Developer
 * Date: 23.06.2020
 * Time: 11:07
 */


package ru.belyaev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.belyaev.entity.User;
import ru.belyaev.service.UserService;

import javax.validation.Valid;

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
    public String checkRegistrationForm(@Valid @ModelAttribute("UserFromRegistrationForm") User user, BindingResult bindingResult, Model model) {
        User existUser = userService.findUserByName(user.getName());
        User existEmail = userService.findUserByEmail(user.getEmail());

        if (bindingResult.hasErrors()) {
            return "registrationForm";
        }

        if ((existUser != null || existEmail != null) || (existUser != null && existEmail != null)) {
            model.addAttribute("mymsg", "User with this Name or Email already exists");
            return "registrationForm";
        }

        userService.addUser(user);
        return "loginPage";
    }

    @GetMapping("/login")
    public String showLoginPage() {

        return "loginPage";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }



}

