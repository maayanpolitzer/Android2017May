package com.example.hackeru.passdatabetweenactivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        int x = getIntent().getIntExtra("number", -1);

        TextView tv = (TextView) findViewById(R.id.text);
        tv.setText("wow it's working! " + x);

    }
}
