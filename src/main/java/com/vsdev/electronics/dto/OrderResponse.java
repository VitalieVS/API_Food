package com.vsdev.electronics.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponse {

    private boolean created;

    private String date;

    private String message;
}
