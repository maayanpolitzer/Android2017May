package com.company;

/**
 * Created by hackeru on 7/10/2017.
 */
public class A implements B {

    private String name;
    private int number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public void wow() {

    }

    @Override
    public boolean wiiiii(int number) {
        return false;
    }
}
