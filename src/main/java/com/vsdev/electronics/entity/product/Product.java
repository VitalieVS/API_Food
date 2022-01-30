package com.vsdev.electronics.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsdev.electronics.entity.order.Order;
import com.vsdev.electronics.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(name = "is_vegetarian")
    private boolean isVegetarian;

    private int price;

    private int weight;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "products_ingredients",
            joinColumns = {
                    @JoinColumn(name = "product_id", referencedColumnName = "product_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id",
                            nullable = false, updatable = false)})
    List<Ingredient> ingredients;

    @Column(name = "image_url")
    String imageURL;

    @JsonIgnore
    @ManyToOne
    private Category product;

    @ManyToMany(mappedBy = "ordersList")
    @JsonIgnore
    private List<User> users;

    @ManyToMany(mappedBy = "productList")
    @JsonIgnore
    private List<Order> orders;

    private int quantity;

}
