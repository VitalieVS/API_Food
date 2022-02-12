package com.vsdev.electronics.controller.user;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.service.users.users.RegisterService;
import com.vsdev.electronics.util.validator.registration.RegisterValidator;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class RegisterController {


    private final RegisterService registerService;

    private final RegisterValidator registerValidator;

    @Inject
    public RegisterController(RegisterService registerService, RegisterValidator registerValidator) {

        this.registerService = registerService;
        this.registerValidator = registerValidator;
    }

    @PostMapping("/register")
    public boolean registerUser(@RequestBody @Validated RegisterRequest registerRequest, BindingResult result) {

        registerValidator.validate(registerRequest, result);

        return registerService.register(registerRequest, result.hasErrors());
    }
}
