package com.company;

/**
 * Created by hackeru on 8/10/2017.
 */
public class User {

    private String name;
    private String password;

    public User(String name, String password){
        this.name = name;
        this.password = password;
    }

    public User(String name){
        this(name, "abc123");
    }



    public void setName(String newName){
        name = newName;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", password: " + password;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof User)){
            return false;
        }
        if(super.equals(obj)){
            return true;
        }
        User temp = (User) obj;
        return name.equals(temp.name) && password.equals(temp.password);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
