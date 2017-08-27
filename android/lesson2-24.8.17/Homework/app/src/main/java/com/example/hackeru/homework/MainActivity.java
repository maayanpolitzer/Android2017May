package com.example.hackeru.homework;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private int counter = 0;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.myText);
        Button addBtn = (Button) findViewById(R.id.add);
        Button minusBtn = (Button) findViewById(R.id.minus);
        Button multiBtn = (Button) findViewById(R.id.multi);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setBackgroundColor(Color.MAGENTA);
            }
        });
        addBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        multiBtn.setOnClickListener(this);

    }

    private void updateView(){
        tv.setText(counter + "");
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.add:
                counter++;
                break;
            case R.id.minus:
                counter--;
                break;
            default:
                counter *= 2;
        }
        updateView();
    }




    /*
    public void doStuff(View view){
        switch(view.getId()){
            case R.id.add:
                counter++;
                break;
            case R.id.minus:
                counter--;
                break;
            default:
                counter *= 2;
        }
        updateView();
    }
*/
}
