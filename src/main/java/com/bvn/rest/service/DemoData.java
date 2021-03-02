package com.bvn.rest.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bvn.rest.model.Department;
import com.bvn.rest.model.Employee;
import com.bvn.rest.model.Role;
import com.bvn.rest.model.Team;
import com.bvn.rest.repository.DepartmentRepository;
import com.bvn.rest.repository.EmployeeRepository;
import com.bvn.rest.repository.RoleRepository;
import com.bvn.rest.repository.TeamRepository;


@Component
public class DemoData {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private TeamRepository teamRepository;

	@EventListener
	@Transactional
    public void appReady(ApplicationReadyEvent event) {
		Role director = new Role(1, "Director");
		Role deptManager = new Role(2, "Department Manager");
		Role teamLead = new Role(3, "Team Leader");
		Role teamMember = new Role(4, "Team Member");
		roleRepository.save(director);
		roleRepository.save(deptManager);
		roleRepository.save(teamLead);
		roleRepository.save(teamMember);
		
		Team it1 = new Team("Team IT 1");
		Team it2 = new Team("Team IT 2");
		Team hr1 = new Team("Team HR 1");
		Team hr2 = new Team("Team HR 2");
		teamRepository.save(it1);
		teamRepository.save(it2);
		teamRepository.save(hr1);
		teamRepository.save(hr2);
		
		Department itDept = new Department("IT Department");
		Department hrDept = new Department("HR Department");
		itDept.addTeam(it1);
		itDept.addTeam(it2);
		hrDept.addTeam(hr1);
		hrDept.addTeam(hr2);
		
		departmentRepository.save(itDept);
		departmentRepository.save(hrDept);
		
		Employee phuongngo = new Employee("Phuong Ngo", "phuongngo@gmail.com");
		Employee jane = new Employee("Jane", "jane@gmail.com");
		Employee luci = new Employee("Luci", "luci@gmail.com");
		Employee john = new Employee("John", "john@gmail.com");
		Employee peter = new Employee("Peter", "peter@gmail.com");
		Employee michell = new Employee("Michell", "michell@gmail.com");
		jane.addTeam(it1);
		luci.addTeam(it2);
		john.addTeam(hr1);
		peter.addTeam(hr2);
		employeeRepository.save(phuongngo);
		employeeRepository.save(jane);
		employeeRepository.save(luci);
		employeeRepository.save(john);
		employeeRepository.save(peter);
		employeeRepository.save(michell);
		director.addEmployee(phuongngo);
		teamMember.addEmployee(jane);
		teamMember.addEmployee(luci);
		teamMember.addEmployee(john);
		teamMember.addEmployee(peter);
		roleRepository.save(teamMember);
		roleRepository.save(director);
    }
}
