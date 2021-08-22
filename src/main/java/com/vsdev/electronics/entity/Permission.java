package com.vsdev.electronics.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "permissions")
public class Permission {
    @Id
    @NotNull
    @Column(name = "permission_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
}
