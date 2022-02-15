package com.vsdev.electronics.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import com.vsdev.electronics.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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
    @JsonIgnore
    private String password;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
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
    @JsonIgnore
    private Role role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_orders",
            joinColumns = @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "order_id"))
    private List<Order> ordersList;

    @Column(name = "total_spent_money")
    private float totalSpentMoney;
}
