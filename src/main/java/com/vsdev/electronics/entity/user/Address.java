package com.vsdev.electronics.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsdev.electronics.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;

    @Column(name = "first_address")
    private String firstAddress;

    @Column(name = "second_address")
    private String secondAddress;

    private String city;

    private String country;

    @OneToOne(mappedBy = "address")
    @JsonIgnore
    private User user;

    @OneToOne(mappedBy = "shippingAddress")
    @JsonIgnore
    private Order order;
}
