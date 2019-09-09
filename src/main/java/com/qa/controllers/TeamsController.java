package com.qa.controllers;

import com.qa.models.Team;
import com.qa.repository.TeamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class TeamsController {

    @Autowired
    private TeamsRepository repository;

    @RequestMapping(value = "teams", method = RequestMethod.GET)
    public List<Team> listAllTeams() {
        return repository.findAll();
    }
    @RequestMapping(value = "teams", method = RequestMethod.POST)
    public Team addTeam(@RequestBody Team team) {
        return repository.saveAndFlush(team);
    }
    @RequestMapping(value = "teams/{id}", method = RequestMethod.GET)
    public Team getTeam(@PathVariable Long id) {
        return repository.findOne(id);
    }
    @RequestMapping(value = "teams/{id}", method = RequestMethod.DELETE)
    public Team deleteTeam(@PathVariable Long id) {
        Team existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
//    @RequestMapping(value = "notes/{id}", method = RequestMethod.POST)
//    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
//        Team existing = repository.findOne(id);
//        repository.findOne(id);
//
//    }

}
