package com.vsdev.electronics.util;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.repository.user_related.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
public class RegisterValidator implements Validator {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return RegisterRequest.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegisterRequest request = (RegisterRequest) o;

        if (userRepository.findUserByLogin(request.getEmail()).isPresent()) {
            errors.rejectValue("email", "This email is already registered!");
        }
    }
}
