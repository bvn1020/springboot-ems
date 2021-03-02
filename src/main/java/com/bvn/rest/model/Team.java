package com.bvn.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.JoinColumn;

@Entity
@Table(name = "team")
public class Team {
	
    @Id
    @SequenceGenerator(name = "teamSeqGen", sequenceName = "TEAM_SEQUENCE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "teamSeqGen")
    private Integer id;
    
    private String name;
    
    @JsonIgnoreProperties("teams")
    @ManyToMany(targetEntity = Employee.class)
    @JoinTable(
			  name = "team_empl", 
			  joinColumns = @JoinColumn(name = "team_id"), 
			  inverseJoinColumns = @JoinColumn(name = "empl_id"))
    private Set<Employee> members;
    
    @JsonIgnoreProperties("teams")
    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private Department department;
    
    public Team() {
    }

    public Team(String name) {
		super();
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

	public Set<Employee> getMembers() {
		return members;
	}

	public void setMembers(Set<Employee> members) {
		this.members = members;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public boolean addEmployee(Employee e) {
		if(this.members == null) {
			this.members = new HashSet<Employee>();
		}
		return this.members.add(e);
	}
}
