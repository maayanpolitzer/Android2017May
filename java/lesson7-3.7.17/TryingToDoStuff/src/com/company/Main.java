package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Enter a number:");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        try {
            int i = Integer.parseInt(str);
            System.out.println(i + 4);
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}
