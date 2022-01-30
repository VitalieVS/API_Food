package com.vsdev.electronics.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;

    @Column(name = "role_name")
    @NotNull
    private String roleName;

    @OneToOne(mappedBy = "role")
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_permissions",
            joinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "role_id",
                            nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id",
                            nullable = false, updatable = false)})
    private Collection<Permission> permissions;
}
