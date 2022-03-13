package com.vsdev.electronics.config;

import com.vsdev.electronics.entity.user.Permission;
import com.vsdev.electronics.entity.user.Role;
import com.vsdev.electronics.filter.JwtFilter;
import com.vsdev.electronics.repository.user.RoleRepository;
import com.vsdev.electronics.service.users.users.UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.inject.Inject;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final JwtFilter jwtFilter;


    private final UserDetailsService userDetailsService;


    private final RoleRepository roleRepository;


    private final PasswordEncoder passwordEncoderService;

    @Inject
    public SecurityConfig(JwtFilter jwtFilter,
                          UserDetailsService userDetailsService,
                          RoleRepository roleRepository,
                          PasswordEncoder passwordEncoderService) {

        this.jwtFilter = jwtFilter;
        this.userDetailsService = userDetailsService;
        this.roleRepository = roleRepository;
        this.passwordEncoderService = passwordEncoderService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoderService);
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        List<Role> roles = roleRepository.findAll();
        http.csrf().disable();

        for (Role role : roles) {
            for (Permission permission : role.getPermissions()) {

                http.authorizeRequests()
                        .antMatchers(permission.getName()).hasAuthority(permission.getName());
            }
        }

        http.authorizeRequests()
                .antMatchers("/login", "/register", "/promotions", "/images/**", "/categories",
                        "/reset/**", "/reset/password")
                .permitAll().anyRequest().authenticated().and().exceptionHandling()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
