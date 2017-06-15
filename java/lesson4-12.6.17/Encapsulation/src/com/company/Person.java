package com.company;

/**
 * Created by hackeru on 6/12/2017.
 */
public class Person {

    private String name;
    private String phone;
    private String address;
    private boolean available;

    public Person(String name, String phone, String address, boolean available){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.available = available;
    }

    public String getName(){
        return name;
    }

    public String getAddress() {
        return address;
    }
}
