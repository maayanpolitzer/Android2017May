package com.company;

/**
 * Created by hackeru on 8/10/2017.
 */
public class User {

    private String email, password;
    private int age = 50, weight=6;

    public User(String email, int age){
        this.email = email;
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return email + ", " + age;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
