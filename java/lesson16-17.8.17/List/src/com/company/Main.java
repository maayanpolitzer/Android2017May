package com.company;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static List<String> users = new ArrayList<>();  // LinkedList

    public static void main(String[] args) {

        addNewUser("Maayan");
        addNewUser("Moshe");
        addNewUser("Maayan");

        System.out.println(users.get(1));

        users.add(1, "Eli");

        users.remove(0);

    }

    public static void addNewUser(String name){
        if(users.contains(name)){
            System.out.println("Fail");
            return;
        }
        users.add(name);
        System.out.println("Success");
    }

}
