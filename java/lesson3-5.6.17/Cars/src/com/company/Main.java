package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Car c1 = new Car("29-547-30", "Maayan", "grey", 2014, true, 5);

        Car c2 = new Car("87-849-08", "Bar", "pink", 2016, false, 4);

        System.out.println(c1.position);
        System.out.println(c2.position);

        c1.drive(3);
        c2.drive(67);
        c2.drive(-44);
        c2.drive(6);

        System.out.println();

        System.out.println(c1.position);
        System.out.println(c2.position);

        /*
        Car c3 = c2;
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        System.out.println(c1.year);
        System.out.println(c2.year);
        System.out.println(c3.year);

        c3.year = -4;
        System.out.println();

        System.out.println(c1.year);
        System.out.println(c2.year);
        System.out.println(c3.year);
        */

    }




}
