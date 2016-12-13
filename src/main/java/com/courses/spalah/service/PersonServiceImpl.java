package com.courses.spalah.service;

import com.courses.spalah.domain.Person;
import com.courses.spalah.persistence.Dao;

import java.util.List;

/**
 * Created by Roman on 24.11.2016.
 */
public class PersonServiceImpl implements PersonService {
    private final Dao<Person, Long> personDao;


    public PersonServiceImpl(Dao<Person, Long> personDao) {
        this.personDao = personDao;

    }

    @Override
    public Person getById(long id) {
        return personDao.getById(id);
    }

    @Override
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public Person delete(long id) {
        return personDao.delete(id);
    }
}
