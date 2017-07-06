package com.company;

/**
 * Created by hackeru on 7/3/2017.
 */
public class Teacher extends Person {

    private int vetek;

    public Teacher(int id, String name, int vetek) {
        super(id, name);
        this.vetek = vetek;
    }

    public int getVetek() {
        return vetek;
    }

}

