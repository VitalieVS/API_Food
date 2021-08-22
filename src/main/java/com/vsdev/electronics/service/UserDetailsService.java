package com.vsdev.electronics.service;

import com.vsdev.electronics.entity.User;
import com.vsdev.electronics.repository.RoleRepository;
import com.vsdev.electronics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByLogin(email);

        if (!user.isPresent()) throw new UsernameNotFoundException("Incorrect login or password");
        return null;

//        return new org.springframework.security.core.userdetails.User(
//                user.get().getLogin(), user.get().
//        )
    }
}
