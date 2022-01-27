package com.vsdev.electronics.service.users.users;

import com.vsdev.electronics.entity.user.User;
import com.vsdev.electronics.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUser(String login) {

        Optional<User> userInDB = userRepository.findUserByLogin(login);

        return userInDB.orElse(null);
    }
}
