package com.vsdev.electronics.service.users.users;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.entity.user.Address;
import com.vsdev.electronics.entity.user.Role;
import com.vsdev.electronics.entity.user.User;
import com.vsdev.electronics.repository.address.AddressRepository;
import com.vsdev.electronics.repository.user.RoleRepository;
import com.vsdev.electronics.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@Service
public class RegisterService {


    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;


    private final RoleRepository roleRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Inject
    public RegisterService(UserRepository userRepository,
                           PasswordEncoder passwordEncoder,
                           RoleRepository roleRepository) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public boolean register(RegisterRequest registerRequest, boolean hasErrors) {

        boolean response = false;

        if (!hasErrors) {

            User toRegister = new User();
            toRegister.setLogin(registerRequest.getEmail());
            toRegister.setName(registerRequest.getName());
            toRegister.setSurname(registerRequest.getSurname());
            toRegister.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
            Address address = addressRepository.save(registerRequest.getAddress());
            toRegister.setAddress(address);
            toRegister.setRole(createUserRole());

            userRepository.save(toRegister);
            response = true;
        }

        return response;
    }

    @Transactional
    public Role createUserRole() {

        Role userRole = roleRepository.findFirstByRoleName("USER");
        roleRepository.save(userRole);

        return userRole;
    }
}
