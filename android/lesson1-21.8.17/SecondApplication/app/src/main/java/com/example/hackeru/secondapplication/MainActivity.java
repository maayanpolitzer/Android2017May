package com.example.hackeru.secondapplication;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 1;
    private TextView tv;
    private boolean working;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.text);
    }

    public void wow(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Ofnei arim")
                .setMessage("For sale")
                .show();
    }

    public boolean isWorking() {
        return working;
    }

    public void updateTV(){
        // called from HANDLER...
        tv.setText(counter++ + "");
    }

    public void changeText(View view) {
        if(!working){
            working = true;
            new CountThread(this).start();
        }else{
            working = false;
        }
    }
}
