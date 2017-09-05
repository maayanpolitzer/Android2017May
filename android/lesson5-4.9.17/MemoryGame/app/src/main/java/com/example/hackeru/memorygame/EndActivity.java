package com.example.hackeru.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        long time = getIntent().getLongExtra("TIME", 0);
        int clicks = getIntent().getIntExtra("COUNTER", 0);

        int score = (int)(1000 - (time/1000 * clicks));

        TextView tv = new TextView(this);
        tv.setTextSize(30);
        tv.setText("Your score is:\n" + score);

        setContentView(tv);

    }
}
