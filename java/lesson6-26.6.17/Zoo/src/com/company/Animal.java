package com.company;

/**
 * Created by hackeru on 6/19/2017.
 */
public class Animal {

    private String name;
    private boolean predator;
    private boolean aquatic;

    public Animal(String name, boolean predator, boolean aquatic){
        this.name = name;
        this.predator = predator;
        this.aquatic = aquatic;
    }

    public String getName() {
        return name;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public boolean isPredator() {
        return predator;
    }
}
