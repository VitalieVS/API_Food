package com.vsdev.electronics.entity;

import lombok.*;
import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Column(name = "first_address")
    private String firstAddress;
    @Column(name = "second_address")
    private String secondAddress;
    private String city;
    private String country;
}
