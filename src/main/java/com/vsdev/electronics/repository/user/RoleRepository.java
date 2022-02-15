package com.vsdev.electronics.repository.user;

import com.vsdev.electronics.entity.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRoleName(String roleName);

    Role findFirstByRoleName(String roleName);
}
