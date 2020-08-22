package ru.belyaev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccessController {

    @GetMapping("/access-denied")
    public String showErrorPage() {
        return "accessDeniedPage";
    }
}
