package com.vsdev.electronics.repository.security;

import com.vsdev.electronics.entity.security.PasswordReset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetRepository extends JpaRepository<PasswordReset, Integer> {

    Optional<PasswordReset> findByToken(String token);
}
