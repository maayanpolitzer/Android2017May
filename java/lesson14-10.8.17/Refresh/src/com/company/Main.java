package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
                                        //    0    1      2
        String[] arr = new String[3];   // [null, null, null];
        String[] arr2 = {"Maayan", "Irit", "Itay"};
        String[] arr3 = new String[]{"Maayan", "Irit", "Itay"};

        //isSum(new int[]{4,3,2}, 9);

        int[] numbers = {5,5,5,3,5};

        //System.out.println(arr2[2]);

        //System.out.println(firstLastSum(null));

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            if (i < numbers.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");


        for(int x : numbers){
            x = -6;
        }

        System.out.print("[");
        for (int i = 0; i < numbers.length; i++){
            System.out.print(numbers[i]);
            if (i < numbers.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");

        //wow(numbers);

        //System.out.println(numbers[0]);
    }

    public static void wow(int[] arr){
        arr[0] = -400;
    }


    public static int firstLastSum(int[] arr){

        if(arr == null || arr.length < 2){
            //throw new IndexOutOfBoundsException();
            return -1;
        }
        return arr[0] + arr[arr.length - 1];

        /*
        // makes this code work slower...
        try {
            return arr[0] + arr[arr.length - 1];
        }catch (IndexOutOfBoundsException e){
            return -1;
        }catch (NullPointerException e){
            return -1;
        }
        */
    }


    public static boolean isSum(int[] arr, int number){
        return true;
    }
}
