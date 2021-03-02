package com.bvn.rest.bo;

import java.util.Set;

import com.bvn.rest.model.Role;
import com.bvn.rest.model.Team;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CompanyStructure {

	private Integer id;
	
	private String name;
	
	private String email;
	
	@JsonIgnoreProperties("members")
	private Set<Team> teams;
	
	@JsonIgnoreProperties("employees")
	private Set<Role> roles;
	
    public CompanyStructure() {

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
}
