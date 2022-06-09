package com.vsdev.electronics.controller.user;

import com.vsdev.electronics.dto.AuthRequest;
import com.vsdev.electronics.dto.LoginResponse;
import com.vsdev.electronics.util.jwt.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.inject.Inject;

@RestController
public class LoginController {

    private final JwtUtil jwtUtil;

    private final AuthenticationManager authenticationManager;

    @Inject
    public LoginController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {

        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public LoginResponse generateToken(@RequestBody AuthRequest authRequest) {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getLogin(), authRequest.getPassword())
            );
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return jwtUtil.generateToken(authRequest.getLogin());
    }
}
