package com.company;

public class Main {

    public static void main(String[] args) {

        Zoo ramatGan = new Zoo("Ramat gan", "Maayan", 4, 2, 5);
        ramatGan.printCages();

        Animal animal = new Animal("Lion", true, false);
        ramatGan.insertAnimal(animal);

    }
}
