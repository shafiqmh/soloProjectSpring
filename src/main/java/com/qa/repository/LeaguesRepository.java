package com.qa.repository;

import com.qa.models.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaguesRepository
        extends JpaRepository<League, Long> {



}
