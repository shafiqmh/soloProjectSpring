package com.qa.repository;

import com.qa.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository
        extends JpaRepository<Team, Long> {



}
