package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Person s1 = new CSStudent(1, "Maayan");

        Person t1 = new Teacher(2, "Moshe", 14);

        ArrayList<Person> people = new ArrayList<>();
        people.add(s1);
        people.add(t1);

        printNames(people);
    }

    public static void printNames(ArrayList<Person> list){
        for (int i = 0; i < list.size(); i++){
            Person p = list.get(i);
            if(p instanceof Student) {
                Student tempStudent = (Student) p;
                System.out.println(tempStudent.getCourse());
            }
        }
    }

}
