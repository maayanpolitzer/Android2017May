package com.company;

public class Main {

    public static void main(String[] args) {
        /*
        int i = 5;
        int[] arr = new int[5];

        Person p1 = new Person();   // p1 - reference / pointer
        System.out.println(p1.name);

        Person p2 = new Person();
        p2.name = "moshe";
        System.out.println("******************");
        System.out.println(p1.name);
        System.out.println("******************");
        System.out.println(p2.name);
        */

        /*
        Animal snake = new Animal();
        Animal lion = new Animal();
        lion.numberOfLegs = 4;
        Animal spider = new Animal();
        spider.numberOfLegs = 8;

        System.out.println(snake.numberOfLegs);
        System.out.println(lion.numberOfLegs);
        System.out.println(spider.numberOfLegs);
        */

        Animal snake = null;
        if(snake != null) {
            snake.numberOfLegs = 5;
        }

    }

    public static void wow(){
        System.out.println("wow!!!!");
    }
}
