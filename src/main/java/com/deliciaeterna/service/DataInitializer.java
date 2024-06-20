package com.deliciaeterna.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.deliciaeterna.entity.Role;
import com.deliciaeterna.entity.User;
import com.deliciaeterna.repository.RoleRepository;
import com.deliciaeterna.repository.UserRepository;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        try {
            // Check if roles already exist
            if (roleRepository.count() == 0) {
                // Create starter roles
                Role adminRole = new Role();
                adminRole.setRoleName("ROLE_ADMIN");
                roleRepository.save(adminRole);
                
                Role userRole = new Role();
                userRole.setRoleName("ROLE_USER");
                roleRepository.save(userRole);
                

                // Create starter users if not exist
                if (!userRepository.existsByUsername("admin")) {
                    User admin = new User();
                    admin.setUsername("admin");
                    admin.setPassword(passwordEncoder.encode("1234"));
                    List<Role> adminRoles = new ArrayList<>();
                    adminRoles.add(adminRole);
                    admin.setRoles(adminRoles);
                    userRepository.save(admin);
                }
                
                if (!userRepository.existsByUsername("user")) {
                    User user = new User();
                    user.setUsername("user");
                    user.setPassword(passwordEncoder.encode("1234"));
                    List<Role> userRoles = new ArrayList<>();
                    userRoles.add(userRole);
                    user.setRoles(userRoles);
                    userRepository.save(user);
                }
                              
            }
        } catch (Exception e) {
            System.out.println("Starter data already exists in the database");
        }
    }
}

