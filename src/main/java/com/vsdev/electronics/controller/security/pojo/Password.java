package com.vsdev.electronics.controller.security.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Password {

    private String token;

    private String firstPassword;

    private String secondPassword;

    private String errorMessage;

    public Password(String token) {
        this.token = token;
    }
}
