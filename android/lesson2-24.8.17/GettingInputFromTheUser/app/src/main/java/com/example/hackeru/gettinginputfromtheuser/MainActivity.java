package com.example.hackeru.gettinginputfromtheuser;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText firstET, lastET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstET = (EditText) findViewById(R.id.firstNameEditText);
        lastET = (EditText) findViewById(R.id.lastNameEditText);

        findViewById(R.id.loginBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String fName = firstET.getText().toString().trim();
        String lName = lastET.getText().toString().trim();
        if(validate(fName, lName)) {
            firstET.setText("");
            lastET.setText("");
            Toast.makeText(this, fName + " " + lName, Toast.LENGTH_LONG).show();
        }
    }

    private boolean validate(String fName, String lName){
        boolean valid = true;
        if(fName.isEmpty()){
            firstET.setError("Must enter first name");
            valid = false;
        }
        if(lName.isEmpty() || lName.length() < 3){
            lastET.setError("Must enter last name");
            valid = false;
        }
        return valid;
    }
}
