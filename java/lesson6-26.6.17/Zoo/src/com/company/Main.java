package com.company;

import java.util.Random;

public class Main {

    public static Animal[] animals = {
            new Animal("Sheep", false, false),
            new Animal("T-rex", true, false),
            new Animal("lamb", false, false),
            new Animal("Shark", true, true),
            new Animal("Gold fish", false, true),
            new Animal("Tiger", true, false),
            new Animal("monkey", false, false),
            new Animal("Star fish", false, true),
            new Animal("dolphin", false, true),
            new Animal("Human", true, false)
    };

    public static void main(String[] args) {

        Zoo ramatGan = new Zoo("Ramat gan", "Maayan", 4, 2, 5);

        Random random = new Random();
        for (int i = 0; i < 20; i++){
            ramatGan.insertAnimal(animals[random.nextInt(animals.length)]);
        }
        ramatGan.printCages();

    }
}
