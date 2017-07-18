package com.company;

public class Main {

    public static void main(String[] args) {

        Animal a1 = new Animal(){};

        Person p1 = new Person(){
            @Override
            public void setName(String name) {
                System.out.println("wow!!!");
            }
        };

        Printable p = new Document();

        Printable p2 = new Printable() {
            @Override
            public void print() {

            }
        };

    }
}
