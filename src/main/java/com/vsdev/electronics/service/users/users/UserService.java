package com.vsdev.electronics.service.users.users;

import com.vsdev.electronics.entity.user.User;
import com.vsdev.electronics.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Inject
    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public User getUser(String login) {  // wrong approach.

        Optional<User> userInDB = userRepository.findUserByLogin(login);

        return userInDB.orElse(null);
    }
}
