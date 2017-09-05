package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(factorial(3));

    }

    public static int factorial(int number){
        if(number == 1){
            return 1;
        }
        return number * factorial(number-1);
    }
}
