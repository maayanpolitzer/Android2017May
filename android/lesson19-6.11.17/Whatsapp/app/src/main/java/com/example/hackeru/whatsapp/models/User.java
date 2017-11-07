package com.example.hackeru.whatsapp.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 11/2/2017.
 */

public class User {

    private int userID;
    private String username;

    public User(JSONObject obj){
        try{
            userID = obj.getInt("user_id");
            username = obj.getString("username");
        }catch (JSONException e){

        }
    }

    public User(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

    public int getUserID() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String toString() {
        return username;
    }
}
