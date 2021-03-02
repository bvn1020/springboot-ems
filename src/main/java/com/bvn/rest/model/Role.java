package com.bvn.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "role")
public class Role {
	
    @Id
    @SequenceGenerator(name = "roleSeqGen", sequenceName = "ROLE_SEQUENCE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "roleSeqGen")
    private Integer id;
    
    private String name;
    
    @JsonIgnoreProperties("roles")
    @ManyToMany(targetEntity = Employee.class)
    @JoinTable(
			  name = "role_empl", 
			  joinColumns = @JoinColumn(name = "role_id"), 
			  inverseJoinColumns = @JoinColumn(name = "empl_id"))
    private Set<Employee> employees;
    
    public Role() {
    }

    public Role(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public boolean addEmployee(Employee e) {
		if(this.employees == null) {
			this.employees = new HashSet<Employee>();
		}
		e.addRole(this);
		return this.employees.add(e);
	}
}
