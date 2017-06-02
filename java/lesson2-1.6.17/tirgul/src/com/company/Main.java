package com.company;

public class Main {

    public static void main(String[] args) {

    }

    public static int x3(int x, int y){
        return x == y ? x * x : x + y;
        /*
        if (x == y){
            return x * x;
        }
        return x + y;
        */

    }

    public static boolean x2(boolean b1, boolean b2){
        return b1 == b2;
        /*
        if((b1 == true && b2 == true) || (b1 == false && b2 == false)){
            return true;
        }
        return false;
        */
    }

    public static boolean x1(boolean b1, boolean b2){
        return (!b1 || b2);
        /*
        if(!b1 || b2){
            return true;
        }
        return false;
        */
        /*
        if(!b1){     // if (b1 == false){
            return true;
        }
        return b2;
        */
        /*
        if(b2){      // if(b2 == true){
            return true;
        }
        return false;
        */

    }
}
