package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static int[] arr = {5,7,4,-5,3,12,-6};
    public static int number = 7;

    public static void main(String[] args) {

        System.out.println(wow());

    }

    private static boolean wow() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++){
            if(set.contains(arr[i])){
                return true;
            }
            set.add(number - arr[i]);
        }
        return false;
    }
}
