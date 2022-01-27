package com.vsdev.electronics.entity.user;

import com.sun.istack.NotNull;
import com.vsdev.electronics.entity.product.Product;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "user_id"))
    private List<Product> ordersList;
}
