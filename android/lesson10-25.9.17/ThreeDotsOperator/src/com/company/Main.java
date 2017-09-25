package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("the average is " + average(76));
    }

    public static int average(int... grades){
        int sum = 0;
        for (int i = 0; i < grades.length; i++){
            sum += grades[i];
        }
        if(grades.length == 0){
            return 0;
        }
        return sum / grades.length;
    }



}
