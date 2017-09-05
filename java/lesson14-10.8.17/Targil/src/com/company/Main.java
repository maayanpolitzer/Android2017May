package com.company;

public class Main {

    private static int[] arr = {2,6,13,14,18,20,26,28,29,33,35,38,49,52,56,57,67,80,100,130,137,204,230,550};
    private static int number = 551;

    public static void main(String[] args) {

        System.out.println("arr size: " + arr.length);
        System.out.println(isSum(arr, number));
        System.out.println(isSumOrder(arr, number));

    }

    public static boolean isSum(int[] arr, int number){
        int counter = 0;
        for (int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                counter++;
                if(arr[i] + arr[j] == number){
                    System.out.println("inner loop iteration count: " + counter);
                    return true;
                }
            }
        }
        System.out.println("inner loop iteration count: " + counter);
        return false;
    }

    public static boolean isSumOrder(int[] arr, int number){
        int counter = 0;
        int min = 0;
        int max = arr.length - 1;
        while(min < max){
            int sum = arr[min] + arr[max];
            counter++;
            if (sum == number){
                System.out.println("Order arr counter: " + counter);
                return true;
            }
            counter++;
            if (sum < number){
                min++;
            }else{
                max--;
            }
        }
        System.out.println("Order arr counter: " + counter);
        return false;
    }

}
