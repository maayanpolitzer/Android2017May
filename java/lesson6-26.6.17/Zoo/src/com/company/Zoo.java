package com.company;

/**
 * Created by hackeru on 6/19/2017.
 */
public class Zoo {

    private String name;
    private String manager;
    private Cage[] cages;

    public Zoo(String name, String manager, int landCages, int aquariums, int cageCapacity){
        this.name = name;
        this.manager = manager;
        cages = new Cage[landCages + aquariums];
        for (int i = 0; i < cages.length; i++){
            cages[i] = new Cage(i < landCages ? false : true, cageCapacity);
        }
    }

    public void insertAnimal(Animal a){
        for (int i = 0; i < cages.length; i++){
            if (cages[i].check(a)){
                cages[i].insertToCage(a);
                return;
            }
        }
        System.out.println("No place for " + a.getName() + "!!!");
    }

    public void printCages(){
        for (int i = 0; i < cages.length; i++){
            System.out.println(cages[i].getDetails());
        }
    }

}
