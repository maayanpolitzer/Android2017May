package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println(sqrt(8));
        System.out.println(wow(5,2));
        System.out.println(kim(7,10));
        System.out.println(bar(45));
        System.out.println(distance(8, 3));
        System.out.println(product(5, 3));
        System.out.println(quatient(10,3));

    }

    public static int distance(int x, int y){
        if(x > y){
            return x - y;
        }else{
            return y - x;
        }
    }

    public static int product(int x, int y){
        return x * y;
    }

    public static int quatient(int x, int y){
        return x / y;
    }

    public static int sqrt(int x){
        int number = x * x;
        return number;
    }

    public static boolean wow(int x, int y){
        return x * y > y;
        /*
        if (x * y > y){
            return true;
        }else{
            return false;
        }
        */
    }

    public static boolean kim(int x, int y){
        return x * 3 == y;
    }

    public static int bar(int k){
        if(k * 30 == 0){
            return 1;
        }else {
            return 0;
        }
    }

}
