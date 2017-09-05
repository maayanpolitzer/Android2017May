package com.company;

public class Main {

    public static void main(String[] args) {

        User[] users = {
                new User("maayan", 31),
                new User("Irit", 31),
                new User("Itay", 3)
        };

        for(int i = 0; i < users.length; i++){
            System.out.print(users[i] + ",");
        }
        System.out.println();

        for(User u : users){
            //u = new User("moshe", 4);
        }



        for(int i = 0; i < users.length; i++){
            System.out.print(users[i] + ",");
        }
        System.out.println();

    }
}
