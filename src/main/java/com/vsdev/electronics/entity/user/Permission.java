package com.vsdev.electronics.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @NotNull
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "permissions", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Role> products;
}
