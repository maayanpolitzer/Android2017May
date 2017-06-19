package com.company;

/**
 * Created by hackeru on 6/19/2017.
 */
public class Cage {

    private int animalsInside;
    private boolean aquatic;
    private boolean predator;
    private Animal[] animals;

    public Cage(boolean aquatic, int maxCapacity){
        this.aquatic = aquatic;
        animals = new Animal[maxCapacity];
    }

}
