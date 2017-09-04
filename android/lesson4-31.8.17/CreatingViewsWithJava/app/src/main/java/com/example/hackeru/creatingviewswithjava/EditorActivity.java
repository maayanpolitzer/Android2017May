package com.example.hackeru.creatingviewswithjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EditorActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        final EditText nameET = (EditText) findViewById(R.id.activity_editor_name_edit_text);

        findViewById(R.id.activity_editor_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString().trim();
                if (name.isEmpty()){
                    nameET.setError("Must by with data..");
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("name", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }
}
