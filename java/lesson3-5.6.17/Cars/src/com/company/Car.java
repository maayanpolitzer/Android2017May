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

    public Car(String licensePlate,String carOwner,String carColor,
               int carYear,boolean autoGear,int doors){
        lp = licensePlate;
        owner = carOwner;
        color = carColor;
        year = carYear;
        auto = autoGear;
        numOfDoors = doors;
        hand = 1;
    }

    public void drive(int movement){
        position += movement;
    }

}
