package com.company;

public class Main {

    private static boolean[][] arr = new boolean[20][50];

    public static void main(String[] args) {

        drawRect(3,3,5,3);
        print();
    }

    private static void drawRect(int left, int top, int width, int height){

    }

    private static void print(){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] ? "X " : "- ");
            }
            System.out.println();
        }
    }


}
