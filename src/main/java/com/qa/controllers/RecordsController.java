package com.qa.controllers;

import com.qa.models.Record;
import com.qa.repository.RecordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class RecordsController {

    @Autowired
    private RecordsRepository repository;

    @RequestMapping(value = "records", method = RequestMethod.GET)
    public List<Record> listAllRecords() {
        return repository.findAll();
    }
    @RequestMapping(value = "records", method = RequestMethod.POST)
    public Record addRecord(@RequestBody Record team) {
        return repository.saveAndFlush(team);
    }
    @RequestMapping(value = "notes/{id}", method = RequestMethod.GET)
    public Record getRecord(@PathVariable Long id) {
        return repository.findOne(id);
    }
    @RequestMapping(value = "notes/{id}", method = RequestMethod.DELETE)
    public Record deleteRecord(@PathVariable Long id) {
        Record existing = repository.findOne(id);
        repository.delete(existing);
        return existing
    }


}
