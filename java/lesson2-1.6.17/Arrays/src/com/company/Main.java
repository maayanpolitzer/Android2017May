package com.company;

public class Main {

    public static void main(String[] args) {

        int x = 5;
        int[] arr1 = new int[x]; // {0,0,-607,0,0}
        int[] arr2 = {10,4,6,1,15};
        int[] arr3 = new int[]{-17,-32,-46,-51,-4};

        arr1[2] = -607;

        //System.out.println(arr1.length);
        //System.out.println(minMax(arr2));
        print(arr2);
        print(reverse(arr2));
    }

    public static void print(int[] arr){
        System.out.print("[");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
            if (i < arr.length - 1){
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] reverse(int[] arr){
        int[] reversedArray = new int[arr.length];
        int counter = arr.length - 1;   // 2
        for (int i = 0; i < arr.length; i++){
            reversedArray[i] = arr[counter];
            counter--;
        }
        return reversedArray;
    }

    public static int minMax(int[] arr){
        if(arr.length > 0) {
            int min = arr[0];
            int max = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    continue;
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
            return max - min;
        }
        return -1;
    }

    public static boolean same(int[] arr){
        return arr[0] == arr[arr.length - 1];
    }

    public static boolean six(int[] x){
        for (int i = 0; i < x.length; i++){
            if (x[i] == 6){
                return true;
            }
        }
        return false;
    }

    public static int average(int[] kim) {
        int sum = 0;
        for(int i = 0; i < kim.length; i++){
            sum += kim[i];
        }
        return sum / kim.length;
    }
}
