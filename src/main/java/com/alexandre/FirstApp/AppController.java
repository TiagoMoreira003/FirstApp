package com.alexandre.FirstApp;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.alexandre.FirstApp.Person;
import java.util.List;


@RestController
public class AppController{

    private List<Person> persons = List.of(new Person("Carlos", 10, 1), new Person("Boby", 2, 2));

    @GetMapping("/Persons")
    public List<Person> get(){
        return persons;
    }

    @GetMapping("/Persons/{id}")
    public Person getPerson(@PathVariable int id){
        for(Person person : persons){
            if(person.id == id){
                return person;
            }
        }

       throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found"); 
    } 

    @DeleteMapping("/Persons/{id}")
    public void deletePerson(@PathVariable int id){
        for(Person person : persons){
            if(person.id == id){
                persons.remove(id);
            }
        }
    }

    @PostMapping("/Persons/{name}/{age}/{id}")
    public String createPerson(@PathVariable String name, @PathVariable int age, 
    @PathVariable int id){
        Person person = new Person(name, age, id);
        return "Name: " + person.getName() + "Age: " + person.getAge();
    }

}