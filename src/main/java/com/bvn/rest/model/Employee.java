package com.bvn.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@SequenceGenerator(name = "emplSeqGen", sequenceName = "EMPL_SEQUENCE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "emplSeqGen")
	private Integer id;
	
	private String name;
	
	private String email;
	
	@JsonIgnoreProperties("members")
	@ManyToMany(targetEntity = Team.class, mappedBy = "members")
	private Set<Team> teams;
	
	@JsonIgnoreProperties("employees")
	@ManyToMany(targetEntity = Role.class, mappedBy = "employees")
	private Set<Role> roles;
	
    public Employee() {

    }

    public Employee(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public Employee(String name, String email, Set<Team> teams) {
		super();
		this.name = name;
		this.email = email;
		this.teams = teams;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public void addTeam(Team e) {
		if(this.teams == null) {
			this.teams = new HashSet<Team>();
		}
		e.addEmployee(this);
		this.teams.add(e);
	}

	public void addRole(Role e) {
		if(this.roles == null) {
			this.roles = new HashSet<Role>();
		}
		this.roles.add(e);
	}

	@Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", email=" + email + "]";
    }
}
