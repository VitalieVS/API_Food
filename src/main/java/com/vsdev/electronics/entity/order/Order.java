package com.vsdev.electronics.entity.order;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsdev.electronics.entity.product.Product;
import com.vsdev.electronics.entity.user.Address;
import com.vsdev.electronics.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(
            name = "order_address",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "address_id")
    )
    private Address shippingAddress;

    @ManyToMany(mappedBy = "ordersList", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<User> user;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_orders",
            joinColumns = @JoinColumn(
                    name = "order_id",
                    referencedColumnName = "order_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "product_id"))
    private List<Product> productList;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "order_status")
    private String orderStatus;

}
