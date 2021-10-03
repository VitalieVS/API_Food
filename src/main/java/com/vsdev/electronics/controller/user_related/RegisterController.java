package com.vsdev.electronics.controller.user_related;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.service.users.RegisterService;
import com.vsdev.electronics.util.RegisterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Autowired
    private RegisterValidator registerValidator;

    @PostMapping("/register")
    public boolean registerUser(@RequestBody @Validated RegisterRequest registerRequest, BindingResult result) {
        registerValidator.validate(registerRequest, result);
        if (result.hasErrors()) {
            return false;
        }
        return registerService.register(registerRequest);
    }
}
