package com.company;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();   // blocking method.
            System.out.println("Welcome " + name);
        }

    }
}
