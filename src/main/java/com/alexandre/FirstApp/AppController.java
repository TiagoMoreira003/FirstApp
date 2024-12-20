package com.alexandre.FirstApp;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.UUID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.alexandre.FirstApp.Person;
import java.util.List;
import com.alexandre.FirstApp.DTOs.UpdateAge;
import com.alexandre.FirstApp.DTOs.CreatePerson;


@RestController
public class AppController{
    public List<Person> persons = new ArrayList<>(List.of(
        new Person("Jose", 20),
        new Person("Carlos", 21)
    ));

    // Get all persons from the list
    @GetMapping("/Persons")
    public List<Person> get(){
        return persons;
    }

    // Get perso by id
    @GetMapping("/Persons/{id}")
    public Person getPerson(@PathVariable UUID id){
        for(Person person : persons){
            if(person.id.equals(id)){
                return person;
            }
        }
       throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"); 
    } 

    // Delete one person from the list
    @DeleteMapping("/Persons/{id}")
    public void deletePerson(@PathVariable UUID id){
        Person personDeleted = null;

        for(Person person : persons){
            if(person.id.equals(id)){
                personDeleted = person;
            }
        }

        if(personDeleted == null)
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }

        persons.remove(personDeleted);
    }

    /*Add the new person to the list */
    @PostMapping("/Persons")
    public String createPerson(@RequestBody CreatePerson createPerson){
        Person person = new Person(createPerson.getName(), createPerson.getAge());
        persons.add(person);
        return "Name: " + person.getName() + " Age: " + person.getAge();
    }

    // Update the age of one person choosen by id
    @PutMapping("/Persons/{id}")
    public String updateAge(@PathVariable UUID id, @RequestBody UpdateAge updateAge)
    {
        for(Person person : persons)
        {
            if(person.id.equals(id))
            {
                person.setAge(updateAge.getAge());
                return "Name: " + person.getName() + " Age: " + person.getAge();
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"); 
    }
} 