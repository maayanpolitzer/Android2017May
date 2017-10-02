package com.example.hackeru.whatsapp.infrastructure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 9/25/2017.
 */

public class BaseActivity extends AppCompatActivity {

    protected SharedPreferences preferences;
    protected SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences("PREFS_FILE_NAME", MODE_PRIVATE);
        editor = preferences.edit();
    }

    /**
     * changes the screen.
     * @param targetClass .class object the target
     * @param closeCurrentActivity should i close the current screen?
     */
     protected void changeActivity(Class targetClass, boolean closeCurrentActivity){
        Intent intent = new Intent(this, targetClass);
        startActivity(intent);
        if(closeCurrentActivity){
            finish();
        }

    }

}
