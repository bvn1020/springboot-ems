package com.bvn.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvn.rest.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
