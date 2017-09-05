package com.company;

public class Main {

    public static void main(String[] args) {

        /*
        boolean b = true;
        b = false;
        b = !b;
        if(!(5 != 5)){
            // condition is true...
        }else{
            // condition is false...
        }
        */

        /*
        byte b1 = 127;
        b1++;
        for(int i = 0; i < 5; i++){
            b1 += 85;
        }
        System.out.println(b1);
        */

        //short s = 32767;

        /*
        int i = Integer.MAX_VALUE;
        System.out.println(i);
        */

        /*
        long r = 1342265786675865645L;
        System.out.println(Long.MAX_VALUE);
        */

        //float f = 5.3f; // 32 bits.

        //double d = 5.3; // 64 bits.

        /*
        char c = 'b';
        byte b = (byte)c;
        System.out.println(b);
        */

        /*
        if(5 != 5 || !(6 >=89) || !false){
            System.out.println("run...");
        }
        */

        /*
        boolean internetAvailable = true;
        if(internetAvailable){
            System.out.println("send data to server");
        }else{
            System.out.println("Tell the user that there is no internet connection");
        }
        */



        /*
        int age = 66;
        if(age < 18){
            System.out.println("kids");
        }
        if(age >= 18 && age < 60){
            System.out.println("normal");
        }
        if (age >= 60){
            System.out.println("old");
        }
        */

        /*
        int age = 18;

        if(age > 18){
            System.out.println("old");
        }else if(age < 18){
            System.out.println("kid");
        }else{
            System.out.println("happy birthday");
        }
        */

        /*
        int age = 10;
        switch(age){
            case 10:
                System.out.println("You are ten years old...");
                break;
            case 14:
                System.out.println("אפשר לרדת לבד במעלית");
                break;
            case 18:
            case 19:
            case 20:
                System.out.println("Army...");
                break;
            default:
                System.out.println("Default...");
        }
        */

        // LOOPS:
        /*
        //for loop:

        for (int i = 0; i < 5; i++){
            System.out.println(i);
        }
        */

        /*
        // while loop:
        int i = 0;
        while(i < 5){
            System.out.println(i);
            i++;
        }
        */

        /*

        // do-while loop:
        // at least one iteration.
        // get data from database...
        int i = 11110;
        do{
            System.out.println(i);
            i++;
        }while(i < 5);
        */

        String[] names = {"Daniel", "Michael", "Yossi"};
        /*
        for(int i = 0; i < names.length; i++){
            String name = names[i];
            System.out.println(name);
        }
        */

        /*
        //for each loop:
        for(String name : names){
            System.out.println(name);
        }
        */

    }
}
