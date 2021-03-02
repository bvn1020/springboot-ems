package com.bvn.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bvn.rest.model.Team;

public interface TeamRepository extends JpaRepository<Team, Integer> {

}
