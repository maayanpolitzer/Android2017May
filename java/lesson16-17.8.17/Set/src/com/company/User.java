package com.company;

/**
 * Created by hackeru on 8/17/2017.
 */
public class User {

    private String name;

    public User(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof User)){
            return false;
        }
        if(obj == this){
            return true;
        }
        User temp = (User) obj;
        return name.equals(temp.name);
    }
}
