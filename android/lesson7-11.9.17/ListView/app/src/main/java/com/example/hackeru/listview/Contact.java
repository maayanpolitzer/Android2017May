package com.example.hackeru.listview;


import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Created by hackeru on 9/11/2017.
 */

public class Contact implements Serializable {

    private String name;
    private String phone;
    private int image;
    private int color;

    public Contact(String name, String phone, @DrawableRes int drawableId, @ColorRes int colorId){
        this.name = name;
        this.phone = phone;
        image = drawableId;
        color = colorId;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", image=" + image +
                ", color=" + color +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }


    public int getImage() {
        return image;
    }

    public int getColor() {
        return color;
    }
}
