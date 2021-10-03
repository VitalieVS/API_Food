package com.vsdev.electronics.util;

import com.vsdev.electronics.dto.RegisterRequest;
import com.vsdev.electronics.repository.user_related.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


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

        if (!validateEmailAddress(request.getEmail())) {
            errors.rejectValue("email", "Email is not valid!");
        }

    }


    private boolean validateEmailAddress(String emailAddress) {
        String regexPattern = "^[(a-zA-Z-0-9-\\_\\+\\.)]+@[(a-z-A-z)]+\\.[(a-zA-z)]{2,3}$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(emailAddress);

        return matcher.matches();
    }
}
