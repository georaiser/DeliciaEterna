package com.deliciaeterna.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.deliciaeterna.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	

}
