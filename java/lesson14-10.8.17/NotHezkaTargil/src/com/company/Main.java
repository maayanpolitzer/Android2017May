package com.company;

public class Main {

    public static void main(String[] args) {

        int[] arr = {9,3,7,7,4};
        System.out.println(wow(arr));
    }

    public static int wow(int[] arr){
        boolean minus = false;
        if(arr[0] < 0){
            minus = true;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++){
            result *= 10;
            result += Math.abs(arr[i]);
        }
        return minus ? result *= -1 : result;
    }
}
