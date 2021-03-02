package com.bvn.rest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "department")
public class Department {
	
    @Id
    @SequenceGenerator(name = "deptSeqGen", sequenceName = "DEPT_SEQUENCE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(generator = "deptSeqGen")
    private Integer id;
    
    private String name;
    
    @JsonIgnoreProperties("department")
    @OneToMany(mappedBy = "department", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Team> teams;
    
    public Department() {
    }

    public Department(Integer id, String name, Set<Team> teams) {
		super();
		this.id = id;
		this.name = name;
		this.teams = teams;
	}

	public Department(String name) {
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

	public Set<Team> getTeams() {
		if(this.teams == null) {
			return new HashSet<Team>();
		}else {
		}
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	public boolean addTeam(Team e) {
		if(this.teams == null) {
			this.teams = new HashSet<Team>();
		}
		e.setDepartment(this);
		return this.teams.add(e);
	}
}
