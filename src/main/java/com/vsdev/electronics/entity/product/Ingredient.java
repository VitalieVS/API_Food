package com.vsdev.electronics.entity.product;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Ingredient {

    @Id
    @Column(name = "ingredient_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ingredient_name")
    private String name;

    @ManyToMany(mappedBy = "ingredients", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Product> product;

}
