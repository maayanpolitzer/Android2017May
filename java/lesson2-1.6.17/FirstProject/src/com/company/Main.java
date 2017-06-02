package com.company;

public class Main {

    public static void main(String[] args) {

        boolean b = false;              // 1 bit - 1/8 byte.

        byte b2 = 4;                    // 1 byte.
        short s = 456;                  // 2 bytes.
        int i2 = 24545656;              // 4 bytes.
        long l = 1233245456658541L;     // 8 bytes.

        float f = 45.546345f;           // 4 bytes.
        double d = 4.345456567;         // 8 bytes.

        char c = '&';                   // 2 bytes.

        b2 = -65;
        c = '0';

        if(f == 45.5){
            // the condition is TRUE!
            System.out.println("yey!!!");
        }else{
            // the condition is FALSE.
            System.out.println("Oh no...");
        }

        if(i2 == 4){
            System.out.println("it's 4");
        }else if(i2 == 5){
            System.out.println("it's 5");
        }else {
            System.out.println("not 4 or 5");
        }

        // loops:
        /*
        for (int i = 0; i < 3; i++){
            System.out.println("for loop " + i);
        }
        */

        /*
        int i = 0;
        while(i < 3){
            System.out.println("while loop " + i);
            i++;
        }
        */

        /*
        int i = 0;
        do{
            i++;
            System.out.println("do while " + i);
        }while(i < 3);
        */

        //int number = sum(600,3);
        //System.out.println(number);

        //System.out.println(distance(8,50));

        //System.out.println(product(400,2));

        //System.out.println(quatient(10,3));
        System.out.println(reminder(10,3));
    }

    public static int quatient(int x, int y){
        int result = 0;
        for (int i = y; i <= x; i+= y){
            result++;
        }
        return result;
    }

    public static int reminder(int x, int y){
        return distance(x,product(quatient(x,y), y));
    }

    public static int product(int x, int y){
        int small = x;
        int large = y;
        if (small > large){
            small = y;
            large = x;
        }
        int result = 0;
        for (int i = 0; i < small; i++){
            result += large;    // result = result + large;
        }
        return result;
    }

    public static int distance(int x, int y){
        if (x > y){
            int counter = 0;
            for (int i = y; i < x; i++){
                counter++;
            }
            return counter;
        }else{
            int counter = 0;
            for (int i = x; i < y; i++){
                counter++;
            }
            /*
            while(x + counter < y){
                counter++;
            }
            */
            return counter;
        }
    }


    public static int sum(int x, int y){
        return x + y;
    }



}
