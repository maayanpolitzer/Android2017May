package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 7/10/2017.
 */
public class Vet {

    private String name;
    private String address;
    private ArrayList<Client> clients;

    public Vet(String name, String address){
        this.name = name;
        this.address = address;
        clients = new ArrayList<>();
    }

    public void addClient(String clientName){
        /*
        Client c = new Client(clientName);
        clients.add(c);
        */
        clients.add(new Client(clientName));
    }

    public void addPetToClient(String clientName, String petName, String petType){
        Pet p = new Pet(petName, petType);
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).getName().equals(clientName)){
                clients.get(i).addPet(p);
            }
        }
    }

    public void printDogOwners(){
        for (int i = 0; i < clients.size(); i++){
            if(clients.get(i).isDogOwner()){
                System.out.println(clients.get(i).getName());
            }
        }
    }

}
