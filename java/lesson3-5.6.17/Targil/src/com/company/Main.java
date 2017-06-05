package com.company;

public class Main {

    public static void main(String[] args) {
	    int[] arr = {-7,4,20,6};
        System.out.println(isSum(arr,22));
    }

    public static boolean isSum(int[] arr, int number){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == number){
                    return true;
                }
            }

        }
        return false;
    }

}
