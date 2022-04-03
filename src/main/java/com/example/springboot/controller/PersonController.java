package com.example.springboot.controller;


import com.example.springboot.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonController {

    private final List<Person> persons = new ArrayList<>();


    @GetMapping(path = "/persons", produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Person> list() {
        return persons;
    }

    @PostMapping(path = "/persons", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person create(@RequestBody Person person) {
        persons.add(person);
        return person;
    }

    @DeleteMapping(path = "/persons/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person delete(@PathVariable(name = "id") Integer id) {
        // TODO
        final Person searchParam = new Person();
        searchParam.setId(id);
        boolean result = persons.remove(searchParam);
        return null;
    }

    @PatchMapping(path = "/persons/{id}", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person patch(@PathVariable(name = "id") Integer id, @RequestBody Person param) {
        final Person searchParam = new Person();
        searchParam.setId(id);

        int index = persons.indexOf(searchParam);
        if (index != -1) {
            final Person person = persons.get(index);
            person.setName(param.getName());
            return person;
        }
        return null;
    }

}
