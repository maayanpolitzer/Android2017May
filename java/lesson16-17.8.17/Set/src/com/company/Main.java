package com.company;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Set<User> users = new HashSet<>();

        users.add(new User("Maayan"));
        users.add(new User("Yossi"));
        users.add(new User("moshe"));
        users.add(new User("Maayan"));
        users.add(new User("shemo"));


        /*
        for(User u : users){
            System.out.println(u);
        }
        */
        users.remove(new User("moshe"));

        System.out.println(users);
    }
}
