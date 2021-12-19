package com.vsdev.electronics.entity.product_related;

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

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "products_ingredients",
            joinColumns = @JoinColumn(
                    name = "product_id",
                    referencedColumnName = "product_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "ingredient_id",
                    referencedColumnName = "ingredient_id"))
    List<Ingredient> ingredients;

    @Column(name = "image_url")
    String imageURL;
}
