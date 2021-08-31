package com.vsdev.electronics.repository.user_related;

import com.vsdev.electronics.entity.user_related.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByLogin(String login);

    User findUserByName(String name);
}
