package com.company;

public class Main {

    public static void main(String[] args) {

        String str = "[Rami, Bar, Moshe, Maayan]";
        str = str.substring(1, str.length()-1);
        //System.out.println(str);

        String[] arr = str.split(", ");
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }



    }
}
