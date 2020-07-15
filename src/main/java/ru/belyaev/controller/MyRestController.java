/*
 * Created by Vologda Developer
 * Date: 06.07.2020
 * Time: 17:07
 */


package ru.belyaev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belyaev.entity.User;

@RestController
public class MyRestController {

    @GetMapping("/rest")
    public User showUser () {
        User user = new User();
        user.setId(1);
        user.setName("Goga");
        return user;
    }

}
