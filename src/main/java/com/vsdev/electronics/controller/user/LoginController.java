package com.vsdev.electronics.controller.user;

import com.vsdev.electronics.dto.AuthRequest;
import com.vsdev.electronics.dto.LoginResponse;
import com.vsdev.electronics.repository.user.UserRepository;
import com.vsdev.electronics.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class LoginController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String welcome() {
        return "Main page";
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
