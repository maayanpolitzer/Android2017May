package com.company;

public class Main {

    public static void main(String[] args) {

        String msg = null;

        if(msg == "mfdk"){
            msg = "WOW!";
        }
        System.out.println(msg);

        /*
        1. msg == null || msg.equals("x")
        2. msg.equals("x") || msg == null   // CRASH!!!
        3. "x".equals(msg) || msg == null
         */

    }
}
