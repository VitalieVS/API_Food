package com.vsdev.electronics.entity.product;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "promotions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Promotion {
    @Id
    @Column(name = "id", nullable = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int promotionId;
    private String title;
    private String body;
    private String image;
    @Column(name = "food_type")
    private String foodType;
    private int price;
}
