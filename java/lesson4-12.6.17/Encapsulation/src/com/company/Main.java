package com.company;

public class Main {

    public static void main(String[] args) {

        Dog[] dogs = new Dog[3];

        Person p1 = new Person("Maayan", "052-956871", "Nahal alexander 4", true);
        dogs[0] = new Dog("Davis", p1);
        dogs[1] = new Dog("Bree", p1);
        dogs[2] = new Dog("Humus", new Person("leah", "050-4764365", "tel aviv", false));

        for (int i = 0; i < dogs.length; i++){
            System.out.println("Dog name: " + dogs[i].getName() + ", owner name: " + dogs[i].getOwner().getName());
        }

        /*
        int[] arr = new int[4]; // [0,0,0,0]
        Dog[] dogs = new Dog[3]; // [null, null, null]

        arr[0] = 456;   // [456,0,0,0]
        dogs[0] = new Dog("Lady"); // [com.company.Dog@12ba45c7, null, null]
        */
        /*

        Dog d1 = new Dog("Boni");

        d1.setNumOfLegs(-6);

        System.out.println(d1.getNumOfLegs());

        */

        /*
        System.out.println(d1.getId());
        System.out.println(d1.getName());

        d1.setName("Lasi");

        System.out.println(d1.getId());
        System.out.println(d1.getName());
        System.out.println(Dog.getCounter());
        */


    }
}
