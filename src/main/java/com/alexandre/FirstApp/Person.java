package com.alexandre.FirstApp;

public class Person {

    private String name;
    private int age;
    public int id;

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

    public Person(String name, int age, int id){
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Person(){}

}