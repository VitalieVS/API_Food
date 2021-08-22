package com.vsdev.electronics.Controller;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.service.users.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping("/register")
    public boolean registerUser(@RequestBody RegisterRequest registerRequest) {
        return registerService.register(registerRequest);
    }
}
