package com.example.hackeru.whatsapp.infrastructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by hackeru on 9/25/2017.
 */

public class BaseActivity extends AppCompatActivity {

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
