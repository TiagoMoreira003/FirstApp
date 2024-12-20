package com.alexandre.FirstApp;

import java.util.UUID;

public class Person {

    private String name;
    private int age;
    public UUID id;

    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.id = UUID.randomUUID();
    }

    public Person(){}

}