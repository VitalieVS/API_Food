package com.vsdev.electronics.controller.security;


import com.vsdev.electronics.dto.ResetLoggedPasswordRequest;
import com.vsdev.electronics.entity.security.GenericResponse;
import com.vsdev.electronics.service.security.PasswordResetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping("/reset/password")
    public GenericResponse resetPassword(@RequestParam("email") String userEmail) {

        return passwordResetService.resetPassword(userEmail);
    }

    @PostMapping("/user/logged/resetPassword")
    public GenericResponse resetLoggedPassword(@RequestBody ResetLoggedPasswordRequest resetLoggedPasswordRequest) {

        return passwordResetService.resetLoggedPassword(resetLoggedPasswordRequest);
    }
}
