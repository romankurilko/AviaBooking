package com.courses.spalah.mvc;

import com.courses.spalah.domain.Person;
import com.courses.spalah.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Roman on 24.11.2016.
 */
@RestController
@RequestMapping(value = "/persons",  produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {
    @Autowired
    private PersonService personService;

    PersonController () {

    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Person> getPerson(@RequestParam long id) {
        Person person = personService.getById(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        Person savedPerson = personService.save(person);
        return new ResponseEntity<>(savedPerson, HttpStatus.OK);
    }
}
