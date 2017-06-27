package com.company;

public class Main {

    public static void main(String[] args) {

        DynamicArray list = new DynamicArray();

        list.add("Moshe");
        list.add("Yossi");
        list.add("Maayan");
        list.add("Yoni");
        list.add("Roey");

        //list.add(0, "K");

        //list.set(1,"r");

        //System.out.println(list.contains("A"));

        //System.out.println(list.get(1));

        DynamicArray temp = list.subList(0,list.size());

        //System.out.println(list.size());

        System.out.println(list.sameAs(temp));

    }
}
