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
        for (int i = 0; i < seats.length; i++){
            if(!seats[i]) {      // same as:  if (seats[i] == false) {
                seats[i] = true;
                return i;
            }
        }
        return -1;
    }

    public boolean buyTicket(int seatNumber){
        if (seatNumber >= seats.length || seatNumber < 0){
            return false;
        }
        if(!seats[seatNumber]) {       //same as: if (seats[seatNumber] == false){
            seats[seatNumber] = true;
            return true;
        }
        return false;
    }

    public boolean cancelTicket(int seatNumber){
        if(seatNumber >= 0 && seatNumber < seats.length) {
            if (seats[seatNumber]) {  // same as: if(seats[seatNumber] == true) {
                seats[seatNumber] = false;
                return true;
            }
        }
        return false;
    }

    public int buyGroup(int seatsAmount){
        if (seatsAmount >= 0 && seatsAmount < seats.length) {
            int counter = 0;
            for (int i = 0; i < seats.length; i++) {
                if (!seats[i]) {
                    counter++;
                    if (counter == seatsAmount) {
                        int firstSeat = i - seatsAmount + 1;
                        buyTickets(firstSeat, seatsAmount);
                        return firstSeat;
                    }
                } else {
                    counter = 0;
                    if (i + seatsAmount >= seats.length) {
                        break;
                    }
                }
            }
        }
        return -1;
    }

    private void buyTickets(int firstSeat, int seatAmount){
        for (int i = firstSeat; i < firstSeat + seatAmount; i++){
            seats[i] = true;
        }
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < seats.length; i++){
            System.out.print(seats[i]);
            if (i < seats.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

}
