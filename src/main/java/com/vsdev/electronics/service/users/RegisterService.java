package com.vsdev.electronics.service.users;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.entity.Permission;
import com.vsdev.electronics.entity.Role;
import com.vsdev.electronics.entity.User;
import com.vsdev.electronics.repository.RoleRepository;
import com.vsdev.electronics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    public boolean register(RegisterRequest registerRequest) {
        Optional<User> user = userRepository.findUserByLogin(registerRequest.getEmail());

        Role userRole = roleRepository.findRoleByRoleName("USER");

        if (user.isPresent()) return false;

        User toRegister = new User();
        toRegister.setLogin(registerRequest.getEmail());
        toRegister.setName(registerRequest.getName());
        toRegister.setSurname(registerRequest.getSurname());
        toRegister.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        toRegister.setAddress(registerRequest.getAddress());
        toRegister.setRole(userRole);

        userRepository.save(toRegister);
        return true;
    }

}
