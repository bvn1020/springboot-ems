package com.bvn.rest.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvn.rest.model.Department;
import com.bvn.rest.model.Employee;
import com.bvn.rest.repository.DepartmentRepository;
import com.bvn.rest.repository.EmployeeRepository;

@RestController
public class CompanyController {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
    
    @GetMapping(path="/company-structure", produces = "application/json")
    public String getCompanyStructure() {
    	JSONObject json = new JSONObject();
    	Employee director = employeeRepository.findById(1).get();
    	List<Department> depts = departmentRepository.findAll();
    	for (Department department : depts) {
    		department.getTeams().forEach(t->{
    			t.setDepartment(null);
    			t.getMembers().forEach(m->{
    				m.setTeams(null);
    				m.setRoles(null);
    			});
    		});
		}
    	json.put("Director", director);
    	json.put("Department", depts);
    	return json.toString();
    }
}
