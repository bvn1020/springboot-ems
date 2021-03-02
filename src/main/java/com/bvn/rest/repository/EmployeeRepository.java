package com.bvn.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvn.rest.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
