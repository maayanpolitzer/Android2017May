package com.company;


import java.util.Random;

public class Main {

    static int[] myLotto = {16,6,19,2,3,14};
    static int myExtra = 6;

    static int[] generatedLotto = new int[6];
    static int generatedExtra;

    static Random random = new Random();

    public static void main(String[] args) {
	    lotto();
        extra();

    }

    public static void lotto(){

    }

    public static void extra(){
        generatedExtra = 1 + random.nextInt(8);
    }

    public static int checkLotto(){
        return 0;
    }

}
