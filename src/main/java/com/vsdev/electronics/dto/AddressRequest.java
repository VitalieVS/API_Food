package com.vsdev.electronics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressRequest {

    private int id;

    private String firstAddress;

    private String secondAddress;

    private String city;

    private String country;
}
