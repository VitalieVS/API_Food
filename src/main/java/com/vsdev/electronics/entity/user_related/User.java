package com.vsdev.electronics.entity.user_related;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private int id;
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @Column(name = "email")
    @NotNull
    private String login;
    @NotNull
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_address",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Address address;
    @OneToOne(cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Role role;
}
