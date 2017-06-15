package com.company;

/**
 * Created by hackeru on 6/5/2017.
 */
public class Car {

    String lp;
    String owner;
    String color;
    int year;
    boolean auto;
    int numOfDoors;
    int hand;
    int position;

    public Car(String lp, String owner, String color, int year, boolean auto, int numOfDoors) {
        this.lp = lp;
        this.owner = owner;
        this.color = color;
        this.year = year;
        this.auto = auto;
        this.numOfDoors = numOfDoors;
        hand = 1;
        position = 0;
    }

    public void drive(int movement){
        position += movement;
    }

}
