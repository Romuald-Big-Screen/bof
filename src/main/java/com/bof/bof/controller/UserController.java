package com.bof.bof.controller;

import com.bof.bof.model.User;
import com.bof.bof.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @GetMapping("/readUser={id}")
    public Optional<User> readUser(@PathVariable Long id) {
        return userService.readUser(id);
    }

}
