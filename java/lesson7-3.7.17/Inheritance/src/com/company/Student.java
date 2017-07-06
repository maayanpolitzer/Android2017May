package com.company;

/**
 * Created by hackeru on 7/3/2017.
 */
public class Student extends Person {

    private String course;

    public Student(int id, String name, String course){
        super(id, name);
        this.course = course;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + ", " + course;
    }
}
