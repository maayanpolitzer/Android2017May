package com.company;

/**
 * Created by hackeru on 6/19/2017.
 */
public class Cage {

    private int animalsInside;
    private boolean aquatic;
    private boolean predator;
    private Animal[] animals;

    public Cage(boolean aquatic, int maxCapacity){
        this.aquatic = aquatic;
        animals = new Animal[maxCapacity];
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public String getDetails(){
        String str = "Aquatic: " + aquatic;
        str += ", predator: " + predator;
        str += ", animalsInside: " + animalsInside;
        str += " [";
        for(int i = 0; i < animalsInside; i++){
            str += animals[i].getName() + ", ";
        }
        str += "]";
        return str;
    }

    public void insertToCage(Animal a){
        if (animalsInside == 0){
            predator = a.isPredator();
        }
        animals[animalsInside++] = a;
    }

    public boolean check(Animal a){
        if (animalsInside == animals.length){
            return false;
        }
        if(aquatic != a.isAquatic()){
            return false;
        }
        if(animalsInside != 0 && a.isPredator() != predator){
            return false;
        }
        if (predator && a.isPredator() && a.getName() != animals[0].getName()){
            return false;
        }
        return true;
    }
}
