package com.qa.repository;

import com.qa.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaguesRepository
        extends JpaRepository<Team, Long> {



}
