package com.vsdev.electronics.controller.security;


import com.vsdev.electronics.entity.security.GenericResponse;
import com.vsdev.electronics.service.security.PasswordResetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class UserResetPasswordController {

    private final PasswordResetService passwordResetService;

    @Inject
    public UserResetPasswordController(PasswordResetService passwordResetService) {

        this.passwordResetService = passwordResetService;
    }

    @PostMapping("/user/resetPassword")
    public GenericResponse resetPassword(@RequestParam("email") String userEmail) {

        return passwordResetService.resetPassword(userEmail);
    }
}
