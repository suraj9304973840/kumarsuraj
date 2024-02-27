package com.hcl.personservice.controller;

import com.hcl.personservice.dto.PersonDto;
import com.hcl.personservice.model.Person;
import com.hcl.personservice.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"api/personService/v1/person"})
public class PersonController {
    private final Logger LOGGER= LoggerFactory.getLogger(PersonController.class.getName());
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService){
        this.personService =personService;
    }
    @GetMapping
    public List<PersonDto> getAll(){
        LOGGER.info("getAll");
        return personService.getAll();
    }
    @GetMapping({"/{id}"})
    public PersonDto getOneById(@PathVariable long id){
        LOGGER.info("getOneById - {}",id);
        return personService.getOneById(id);
    }
    @PostMapping
    public PersonDto create(@RequestBody PersonDto personDto){
        LOGGER.info("create - {}",personDto);
        return personService.create(personDto);
    }
    @PutMapping
    public PersonDto update(@RequestBody PersonDto personDto){
        LOGGER.info("update - {}",personDto);
        return personService.update(personDto);
    }
    @DeleteMapping({"/{id}"})
    public boolean delete(@PathVariable long id){
        LOGGER.info("delete - {}",id);
        return personService.delete(id);
    }
}
