package com.example.RestTest.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.RestTest.model.Person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    
    public List<Person> personList = new ArrayList<>();

    @GetMapping("/persons")
    public List<Person> getPersons() {
        personList.add(new Person("David", "McInnes"));
        return personList;
    }

}
