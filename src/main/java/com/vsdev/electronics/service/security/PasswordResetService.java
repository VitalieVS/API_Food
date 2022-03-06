package com.vsdev.electronics.service.security;

import com.vsdev.electronics.controller.security.UserNotFoundException;
import com.vsdev.electronics.controller.security.pojo.Password;
import com.vsdev.electronics.dto.ResetLoggedPasswordRequest;
import com.vsdev.electronics.entity.security.GenericResponse;
import com.vsdev.electronics.entity.security.PasswordReset;
import com.vsdev.electronics.entity.user.User;
import com.vsdev.electronics.repository.security.PasswordResetRepository;
import com.vsdev.electronics.repository.user.UserRepository;
import com.vsdev.electronics.util.jwt.JwtUtil;
import com.vsdev.electronics.util.mail.Templates;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Optional;

@Service
public class PasswordResetService {

    private final UserRepository userRepository;

    private final PasswordResetRepository passwordResetRepository;

    private final JwtUtil jwtUtil;

    private final JavaMailSender javaMailSender;

    private final PasswordEncoder passwordEncoder;

    @Inject
    public PasswordResetService(UserRepository userRepository,
                                PasswordResetRepository passwordResetRepository,
                                JwtUtil jwtUtil,
                                JavaMailSender javaMailSender,
                                PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordResetRepository = passwordResetRepository;
        this.jwtUtil = jwtUtil;
        this.javaMailSender = javaMailSender;
        this.passwordEncoder = passwordEncoder;
    }

    public GenericResponse resetLoggedPassword(ResetLoggedPasswordRequest resetLoggedPasswordRequest) {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String email = userDetails.getUsername();

        GenericResponse response = new GenericResponse("Password changed!", "Success!");

        Optional<User> userInDB = userRepository.findUserByLogin(email);

        try {

            if (!userInDB.isPresent()) {

                response.setMessage("Not found");
                response.setError("Error");
                throw new UserNotFoundException("User not found");
            }

            if (encoder.matches(resetLoggedPasswordRequest.getCurrentPassword(), userInDB.get().getPassword())) {

                userInDB.get().setPassword(passwordEncoder.encode(resetLoggedPasswordRequest.getChangeToPassword()));
                userRepository.save(userInDB.get());
            } else {

                response.setMessage("Could not change password!");
                response.setError("Error!");
            }


        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        return response;
    }


    public GenericResponse resetPassword(String email) {

        GenericResponse response = new GenericResponse("Password reset link sent", "Success!");

        Optional<User> userInDB = userRepository.findUserByLogin(email);

        try {

            if (!userInDB.isPresent()) {

                response.setMessage("Not found");
                response.setError("Error");
                throw new UserNotFoundException("User not found");
            }

            PasswordReset passwordReset = new PasswordReset();

            String token = jwtUtil.generateToken(email).getToken();

            passwordReset.setToken(token);
            passwordReset.setUser(userInDB.get());

            this.passwordResetRepository.save(passwordReset);

            javaMailSender.send(constructResetTokenEmail(token, userInDB.get()));


        } catch (UserNotFoundException | MessagingException e) {
            e.printStackTrace();
        }

        return response;
    }

    public MimeMessage constructResetTokenEmail(String token, User user) throws MessagingException {

        return constructEmail("Food Shop Reset Your Password", user, token);
    }

    public MimeMessage constructEmail(String subject, User user, String token) throws MessagingException {

        MimeMessage message = javaMailSender.createMimeMessage();

        message.setSubject(subject);
        MimeMessageHelper helper;
        helper = new MimeMessageHelper(message, true);
        helper.setTo("vitaliesandiuc@gmail.com"); // use here
        helper.setText(Templates.resetEmailTemplate(token), true);

        return message;
    }

    public String handleReset(String token) {

        String response = "resetpassword";

        if (jwtUtil.isTokenExpired(token)) {
            response = "expired";
        }

        return response;

    }

    public String handlePOSTReset(Password password) {

        String response = "success";

        boolean isExpired = jwtUtil.isTokenExpired(password.getToken());

        boolean passwordsIdentical = password.getFirstPassword().equals(password.getSecondPassword());

        if (!passwordsIdentical) {
            password.setErrorMessage("Passwords does not match!");
            response = "resetpassword";
        }

        if (isExpired) {
            password.setErrorMessage("Token is expired!");
            response = "error";
        }

        if (passwordsIdentical && !isExpired) {

            Optional<User> userInDB = userRepository.findUserByLogin(jwtUtil.extractUsername(password.getToken()));

            userInDB.ifPresent(user -> user.setPassword(passwordEncoder.encode(password.getFirstPassword())));

            userInDB.ifPresent(userRepository::save);

            if (!userInDB.isPresent()) {
                response = "error";
            }
        }

        return response;

    }

}
