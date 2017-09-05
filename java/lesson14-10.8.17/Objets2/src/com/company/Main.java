package com.company;

public class Main {

    public static void main(String[] args) {

       User u1 = new User("moshe", "12");
       User u2 = u1;
       System.out.println(u1 == u2);

    }
}
