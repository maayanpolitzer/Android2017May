package com.company;

public class Main {

    public static void main(String[] args) {

        displayData("Maayan", Status.MARRIED);
        System.out.println(Day.FRIDAY);

    }

    public static void displayData(String name, Status s){
        System.out.println(name + ", " + s);
        switch(s){
            case SINGLE:

                break;
            case DIVORCED:

                break;
        }
    }

    enum Day {
        SUNDAY, MONDAY, FRIDAY,
    }

}

