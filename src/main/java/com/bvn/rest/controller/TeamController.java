package com.bvn.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bvn.rest.model.Team;
import com.bvn.rest.repository.TeamRepository;

@RestController
@RequestMapping(path = "/teams")
public class TeamController {
	@Autowired
	private TeamRepository teamRepository;
    
    @GetMapping(produces = "application/json")
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }
}
