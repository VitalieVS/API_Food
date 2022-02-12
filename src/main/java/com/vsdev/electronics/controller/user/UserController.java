package com.vsdev.electronics.controller.user;

import com.vsdev.electronics.entity.user.User;
import com.vsdev.electronics.service.users.users.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/user/{login}")
    public User getUser(@PathVariable String login) {

        return userService.getUser(login);
    }
}
