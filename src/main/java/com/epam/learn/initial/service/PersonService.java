package com.epam.learn.initial.service;

import com.epam.learn.initial.entity.Person;

import java.util.List;

public interface PersonService {

    List<Person> getAllPersons();

    void savePerson(Person person);
}
