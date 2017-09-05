package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        /*
        Map<String, String> users = new HashMap<>();
        users.put("Maayan", "123");
        users.put("Yossi", "123");
        users.put("Eli", "123");
        users.put("Maayan", "gersd");

        System.out.println(users);

        System.out.println(users.get("Eli"));

        if(users.remove("Eli", "124")){
            System.out.println("wow!!!! DELETE");
        }

        for (String key : users.keySet()){
            if(users.get(key).equals("123")){
                System.out.println(key);
            }
        }
        */

        Map<String, Float> fruits = new HashMap<>();
        fruits.put("Apple", 9.9f);
        fruits.put("Banana", 12.9f);
        fruits.put("Orange", 7.9f);

        System.out.println(fruits);

        for(String key : fruits.keySet()){
            fruits.replace(key, fruits.get(key) * 1.17f);
        }

        for (String key : fruits.keySet()){
            System.out.printf("%s = %.2f" , key, fruits.get(key));
            System.out.println();
        }

    }
}
