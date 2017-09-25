package com.example.hackeru.whatsapp.infrastructure;

import android.widget.EditText;

/**
 * Created by hackeru on 9/25/2017.
 */

public class Validation {


    /**
     * validate a password
     * @param passwordET
     * @return the password if its good, null if NOT.
     */
    public static String validatePassword(EditText passwordET){
        String password = passwordET.getText().toString().trim();
        if(password.isEmpty()){
            passwordET.setError("Password cannot be empty");
            return null;
        }
        if(password.length() < 6){
            passwordET.setError("Password more than 6 chars...");
            return null;
        }
        /*
        boolean capital = false;
        for (int i = 0; i < password.length(); i++){
            if(password.charAt(i) >= 65 && password.charAt(i) <= 90){
                capital = true;
                break;
            }
        }
        if(!capital){
           passwordET.setError("Password must be with atleast one capital letter");
            return null;
        }
        */
        return password;
    }

    /**
     * validate a email
     * @param emailET
     * @return the email if its good, null if NOT.
     */
    public static String validateEmail(EditText emailET) {
        String email = emailET.getText().toString().trim();
        if(email.isEmpty()){
            emailET.setError("Email cannot be empty");
            return null;
        }
        if(!email.contains("@")){
            emailET.setError("Email must contain @");
            return null;
        }
        return email;
    }
}
