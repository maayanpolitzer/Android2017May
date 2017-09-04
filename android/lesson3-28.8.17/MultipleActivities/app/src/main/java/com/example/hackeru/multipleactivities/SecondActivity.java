package com.example.hackeru.multipleactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText nameET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nameET = (EditText) findViewById(R.id.editText);
    }

    public void btnClick(View view) {
        String content = nameET.getText().toString().trim();
        if(!content.isEmpty()){
            // pass content to MainActivity...
            Intent intent = new Intent();
            intent.putExtra("name", content);
            setResult(RESULT_OK, intent);
            finish();
        }else{
            nameET.setError("Cannot be empty.:(");
        }
    }
}
