package com.vsdev.electronics.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "user_id")
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Column(unique = true, name = "email")
    @NotNull
    private String login;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;
}
