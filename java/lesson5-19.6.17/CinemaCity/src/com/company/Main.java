package com.company;

public class Main {

    public static void main(String[] args) {

        Hall h1 = new Hall("Spy", 10);

        //System.out.println(h1.buyTicket());
        System.out.println(h1.buyTicket(2));
        System.out.println(h1.buyTicket(3));
        System.out.println(h1.buyTicket(4));
        System.out.println(h1.buyTicket(8));

        System.out.println(h1.cancelTicket(3));

        System.out.println(h1.buyGroup(2));
        System.out.println(h1.buyGroup(2));


        h1.print();

    }
}
