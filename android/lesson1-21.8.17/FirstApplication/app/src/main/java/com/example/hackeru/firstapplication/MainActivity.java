package com.example.hackeru.firstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void wow(View view){
        Button btn = (Button) view;
        btn.setText(counter++ + "");
        //System.out.println(btn.getText().toString());
        //System.out.println("button click worked!");
        //Toast.makeText(this, "wow!!!", Toast.LENGTH_LONG).show();
        //Toast.makeText(this, R.string.message, Toast.LENGTH_SHORT).show();
    }

}
