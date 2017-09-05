package com.example.hackeru.memorygame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startGame(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("LEVEL", Integer.parseInt(view.getTag().toString()));
        //intent.putExtra("LEVEL", (int) view.getTag());
        startActivity(intent);
    }
}
