package com.example.hackeru.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String NAME = "name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences preferences = getSharedPreferences("maayanPrefs", MODE_PRIVATE);  // get data from file.
        final SharedPreferences.Editor editor = preferences.edit();   // changes in file (set/delete...)

        final EditText nameET = (EditText) findViewById(R.id.activity_main_name_edit_text);

        String myName = preferences.getString(NAME, null);
        nameET.setText(myName);

        findViewById(R.id.activity_main_save_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameET.getText().toString().trim();
                editor.putString(NAME, name);
                editor.putInt("age", 31);
                editor.commit();    // important important important make the changes...
            }
        });

    }
}
