package com.vsdev.electronics.service.users_related.users;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.entity.user_related.Role;
import com.vsdev.electronics.entity.user_related.User;
import com.vsdev.electronics.repository.user_related.RoleRepository;
import com.vsdev.electronics.repository.user_related.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Transactional
    public boolean register(RegisterRequest registerRequest) {

        User toRegister = new User();
        toRegister.setLogin(registerRequest.getEmail());
        toRegister.setName(registerRequest.getName());
        toRegister.setSurname(registerRequest.getSurname());
        toRegister.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        toRegister.setAddress(registerRequest.getAddress());
        toRegister.setRole(createUserRole());

        userRepository.save(toRegister);
        return true;
    }

    @Transactional
    public Role createUserRole() {

        Role userRole = roleRepository.findRoleByRoleName("USER");
        roleRepository.save(userRole);

        return userRole;
    }
}
