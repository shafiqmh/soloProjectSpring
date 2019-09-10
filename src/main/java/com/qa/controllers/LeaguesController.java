package com.qa.controllers;

import com.qa.models.League;
import com.qa.repository.LeaguesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class LeaguesController {

    @Autowired
    private LeaguesRepository repository;

    @RequestMapping(value = "leagues", method = RequestMethod.GET)
    public List<League> listAllLeagues() {
        return repository.findAll();
    }
    @RequestMapping(value = "leagues", method = RequestMethod.POST)
    public League addLeague(@RequestBody League league) {
        return repository.saveAndFlush(league);
    }
    @RequestMapping(value = "leagues/{id}", method = RequestMethod.GET)
    public League getLeague(@PathVariable Long id) {
        return repository.findOne(id);
    }
    @RequestMapping(value = "leagues/{id}", method = RequestMethod.DELETE)
    public League deleteLeague(@PathVariable Long id) {
        League existing = repository.findOne(id);
        repository.delete(existing);
        return existing;
    }
//    @RequestMapping(value = "notes/{id}", method = RequestMethod.POST)
//    public League updateLeague(@PathVariable Long id, @RequestBody League league) {
//        League existing = repository.findOne(id);
//        repository.findOne(id);
//
//    }

}
