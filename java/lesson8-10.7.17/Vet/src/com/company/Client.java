package com.company;

import java.util.ArrayList;

/**
 * Created by hackeru on 7/10/2017.
 */
public class Client {

    private String name;
    private ArrayList<Pet> pets;
    private boolean dogOwner;

    public Client(String name){
        this.name = name;
        pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPet(Pet p){
        if (p.getType().equals("Dog")){
            dogOwner = true;
        }
        pets.add(p);
    }

    public boolean isDogOwner(){
        return dogOwner;
        /*
        for (int i = 0; i < pets.size(); i++){
            if (pets.get(i).getType().equals("Dog")){
                return true;
            }
        }
        return false;
        */
    }
}
