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
        for (int i = 0; i < landCages; i++){
            cages[i] = new Cage(false, cageCapacity);
        }
    }

    public void printCages(){
        for (int i = 0; i < cages.length; i++){
            System.out.println(cages[i]);
        }
    }

}
