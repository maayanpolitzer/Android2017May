package com.company;

/**
 * Created by hackeru on 6/12/2017.
 */
public class Hall {

    private boolean[] seats;
    private String name;

    public Hall(String name, int numOfSeats){
        this.name = name;
        seats = new boolean[numOfSeats];    // [false, false, false, false,...]
    }

    public int buyTicket(){
        return -1;
    }

    public boolean buyTicket(int seatNumber){
        return false;
    }

    public boolean cancelTicket(int seatNumber){
        return false;
    }

    public int buyGroup(int seatsAmount){
        return -1;
    }

}
