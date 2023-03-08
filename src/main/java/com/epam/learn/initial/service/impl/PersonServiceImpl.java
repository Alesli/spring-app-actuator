package com.epam.learn.initial.service.impl;

import com.epam.learn.initial.dao.PersonRepository;
import com.epam.learn.initial.entity.Person;
import com.epam.learn.initial.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

}
