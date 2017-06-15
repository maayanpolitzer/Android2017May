package com.company;


import java.util.Random;

public class Main {

    static int[] myLotto = {1,2,3,4,5,6};
    static int myExtra = 6;

    static int[] generatedLotto = new int[6];
    static int generatedExtra;

    static Random random = new Random();

    public static void main(String[] args) {
	    lotto();
        extra();
        int results = checkLotto();
        System.out.println("extra: " + generatedExtra);
        System.out.println("you guessed " + results + " from 6, and the extra is " + (myExtra == generatedExtra));
    }

    public static void lotto(){
        for(int i = 0; i < generatedLotto.length; i++){
            int randomNumber = 1 + random.nextInt(36);
            if(checkNumber(randomNumber,i)){
                generatedLotto[i] = randomNumber;
                System.out.println(generatedLotto[i]);
            }else{
                System.out.println("OH NO!!!!! " + randomNumber);
                i--;
            }
        }
    }

    public static boolean checkNumber(int number, int max){
        for (int i = 0; i < max; i++){
            if (generatedLotto[i] == number){
                return false;
            }
        }
        return true;
    }

    public static void extra(){
        generatedExtra = 1 + random.nextInt(8);
    }

    public static int checkLotto(){
        int counter = 0;
        for (int i = 0; i < myLotto.length; i++){
            for (int j = 0; j < generatedLotto.length; j++){
                if (myLotto[i] == generatedLotto[j]){
                    counter++;
                    break;
                }
            }
        }
        return counter;
    }

}
