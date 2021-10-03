package com.vsdev.electronics.repository.user_related;

import com.vsdev.electronics.entity.user_related.UserPermission;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserPermissionRepository extends JpaRepository<UserPermission, Integer> {

}
