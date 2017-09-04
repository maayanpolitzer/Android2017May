package com.example.hackeru.creatingviewswithjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mainLayout;

    private static final int EDITOR_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = (LinearLayout) findViewById(R.id.activity_main_layout);
        Button btn = new Button(this);
        btn.setText("click me");
        btn.setOnClickListener(this);
        mainLayout.addView(btn);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, EditorActivity.class);
        startActivityForResult(intent, EDITOR_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == EDITOR_REQUEST_CODE){
            if (resultCode == RESULT_OK){
                TextView tv = new TextView(this);
                tv.setText(data.getStringExtra("name"));
                mainLayout.addView(tv);
            }else{
                // RESULT_CANCELED is 0.
                Toast.makeText(this, "Cancel...", Toast.LENGTH_LONG).show();
            }

        }
    }
}
