package com.company;

/**
 * Created by hackeru on 7/17/2017.
 */
public class Word {

    private String hebrew;
    private String english;

    public Word(String hebrew, String english) {
        this.hebrew = hebrew;
        this.english = english;
    }

    public String getHebrew() {
        return hebrew;
    }

    public String getEnglish() {
        return english;
    }
}
