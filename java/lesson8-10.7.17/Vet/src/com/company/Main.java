package com.company;

public class Main {

    public static void main(String[] args) {

        Vet v = new Vet("Dr. dulitel", "Hertzeliya");

        v.addClient("Maayan");
        v.addClient("Moshe");
        v.addClient("Yossi");

        v.addPetToClient("Moshe", "meatC", "Cat");
        v.addPetToClient("Maayan", "Susi", "Horse");
        v.addPetToClient("Moshe", "Jerry", "Mouse");
        v.addPetToClient("Moshe", "Lasi", "Dog");
        v.addPetToClient("Moshe", "Mogli", "Dog");
        v.addPetToClient("Yossi", "Lucky", "Dog");

        v.printDogOwners();

    }
}
