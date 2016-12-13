package com.courses.spalah.service;

import com.courses.spalah.domain.Person;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */
public interface PersonService {
    Person getById(long id);

    Person save(Person person);

    List<Person> getAll();

    Person delete(long id);
}
