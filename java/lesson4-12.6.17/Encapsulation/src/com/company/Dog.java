package com.company;

/**
 * Created by Maayan on 6/12/2017.
 */
public class Dog {

    private static int counter;
    private int numOfLegs;
    private String name;
    private int id;
    private boolean alive;
    private Person owner;

    public Dog(String name, Person owner){
        this.name = name;
        this.owner = owner;
        numOfLegs = 4;
        id = ++counter;
        alive = true;
    }

    public Person getOwner(){
        return owner;
    }

    public void setNumOfLegs(int numOfLegs) {
        if (numOfLegs >= 0 && numOfLegs <= 4) {
            this.numOfLegs = numOfLegs;
        }else{
            System.out.println("a dog cannot have " + numOfLegs + " legs");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static int getCounter() {
        return counter;
    }

    public int getNumOfLegs() {
        return numOfLegs;
    }



    public int getId() {
        return id;
    }

    public boolean isAlive() {
        return alive;
    }
}
