package com.example.hackeru.passdatabetweenactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int counter = 6;

        Intent intent = new Intent(this, NextActivity.class);
        intent.putExtra("number", counter);
        startActivity(intent);


    }
}
