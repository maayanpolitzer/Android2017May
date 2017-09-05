package com.company;

/**
 * Created by hackeru on 8/7/2017.
 */
public class User {

    private String name;
    private int age;
    private static float vat = 0.17f;

    public User(String name, int age){
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
