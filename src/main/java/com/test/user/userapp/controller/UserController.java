package com.test.user.userapp.controller;

import com.test.user.userapp.dto.User;
import com.test.user.userapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }

    @GetMapping("/hello")
    public String getHello(){
        return "Hello Welcome to you Home Page";
    }

}
