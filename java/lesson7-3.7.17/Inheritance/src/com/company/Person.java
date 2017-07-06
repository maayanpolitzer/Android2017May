package com.company;

/**
 * Created by hackeru on 7/3/2017.
 */
public class Person {

    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails(){
       return id + ", " + name;
    }
}
