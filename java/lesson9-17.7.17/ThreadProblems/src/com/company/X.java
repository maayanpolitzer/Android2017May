package com.company;

/**
 * Created by hackeru on 7/17/2017.
 */
public class X {

    private int number;

    public synchronized void increment(){
        number++;
    }

    public int getNumber(){
        return number;
    }

}
