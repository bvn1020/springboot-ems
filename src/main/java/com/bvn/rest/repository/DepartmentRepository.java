package com.bvn.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvn.rest.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
