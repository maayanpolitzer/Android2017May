package com.company;

public class Main {

    public static void main(String[] args) {

        int[] arr = new int[4]; // [-80, 0, 407, 0]
        arr[0] = -80;
        arr[2] = 407;

        //System.out.println(arr[2]);
        //System.out.println(arr.length);

        //print(arr);
        //System.out.println(sum(arr));
        System.out.println(sameIntInArray(arr, 407));
    }

    public static int sameIntInArray(int[] x, int number){
        int counter = 0;
        for (int i = 0; i < x.length; i++){
            if (x[i] == number){
                counter++;  // counter = counter + 1;
            }
        }
        return counter;
    }

    public static int sum(int[] x){
        int sum = 0;
        for (int i = 0; i < x.length; i++){
            sum += x[i];
        }
        return sum;
    }

    public static void print(int[] x){
        for (int i = 0; i < x.length; i++){
            if(x[i] == -80){
                System.out.println("WOW it's -80!!!");
            }else{
                System.out.println(x[i]);
            }
        }
    }

}
