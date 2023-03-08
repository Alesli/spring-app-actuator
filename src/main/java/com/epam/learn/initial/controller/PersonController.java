package com.epam.learn.initial.controller;

import com.epam.learn.initial.entity.Person;
import com.epam.learn.initial.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    @Autowired
    private PersonService personService;


    @GetMapping
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }

    @PostMapping
    public void savePerson(@RequestBody Person person) {
        personService.savePerson(person);
    }
}
