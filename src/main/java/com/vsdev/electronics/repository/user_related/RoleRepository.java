package com.vsdev.electronics.repository.user_related;

import com.vsdev.electronics.entity.user_related.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findRoleByRoleName(String roleName);
}
