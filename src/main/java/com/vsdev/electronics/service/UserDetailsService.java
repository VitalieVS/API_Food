package com.vsdev.electronics.service;

import com.vsdev.electronics.entity.Permission;
import com.vsdev.electronics.entity.Role;
import com.vsdev.electronics.entity.User;
import com.vsdev.electronics.repository.RoleRepository;
import com.vsdev.electronics.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByLogin(email);

        if (user.isEmpty()) throw new UsernameNotFoundException("Incorrect login or password");

        return new org.springframework.security.core.userdetails.User(
                user.get().getLogin(), user.get().getPassword(), true,
                true, true, true,
                getAuthorities(Collections.singletonList(
                        roleRepository.findRoleByRoleName(user.get().getRole().getRoleName())
                )));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(
            Collection<Role> roles) {
        return getGrantedAuthorities(getPermissions(roles));
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> permissions) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String permission : permissions) {
            authorities.add(new SimpleGrantedAuthority(permission));
        }

        return authorities;
    }

    private List<String> getPermissions(Collection<Role> roles) {
        List<String> permissions = new ArrayList<>();
        List<Permission> permissionsContainer = new ArrayList<>();

        for (Role role : roles) {
            permissionsContainer.addAll(role.getPermissions());
        }

        for (Permission permission : permissionsContainer) {
            permissions.add(permission.getName());
        }

        return permissions;

    }
}
