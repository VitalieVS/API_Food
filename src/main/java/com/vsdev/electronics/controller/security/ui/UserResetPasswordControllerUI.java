package com.vsdev.electronics.controller.security.ui;

import com.vsdev.electronics.controller.security.pojo.Password;
import com.vsdev.electronics.service.security.PasswordResetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.inject.Inject;

@Controller
public class UserResetPasswordControllerUI {

    private final PasswordResetService passwordResetService;

    @Inject
    public UserResetPasswordControllerUI(PasswordResetService passwordResetService) {

        this.passwordResetService = passwordResetService;
    }

    @GetMapping("/reset/{token}")
    public String getResetView(Model model,
                               @PathVariable(name = "token") String token) {

        model.addAttribute("password", new Password(token));

        return this.passwordResetService.handleReset(token);
    }


    @PostMapping("/resetpassword")
    public String getResetView(@ModelAttribute Password password, Model model) {

        return this.passwordResetService.handlePOSTReset(password);
    }

}
