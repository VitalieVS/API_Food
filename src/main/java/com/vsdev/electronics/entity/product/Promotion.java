package com.vsdev.electronics.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vsdev.electronics.entity.order.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "promotions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Promotion {

    @Id
    @Column(name = "promotion_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String body;

    private String image;

    @Column(name = "food_type")
    private String foodType;

    private int price;

    @ManyToMany(mappedBy = "promotionList")
    @JsonIgnore
    private List<Order> orders;
}
