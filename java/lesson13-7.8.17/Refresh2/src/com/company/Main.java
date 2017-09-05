package com.company;

public class Main {

    public static void main(String[] args) {
	    sendSMS("mom", "hi ma kore");
	    sendSMS("wife", "hi baby");
	    sendSMS("dad", "how are you");

        System.out.println(sum(6,5));
    }



    // sum();
    public static int sum(){
        return 3;
    }

    // sum(String,int)
    public static int sum(String name, int first){
       return 4;
    }

    // sum(int, String)
    public static int sum(int number, String name){
        return 3;
    }

    // sum(int,int)
    public static int sum(int first, int second){
       int result = first + second;
       return result;
    }

    // sendSMS(String,String)
    public static void sendSMS(String to, String message){
        /*

         */
    }

    public static void wow(){
        int x = 5;
        x++;
        x -= 6;
    }
}
