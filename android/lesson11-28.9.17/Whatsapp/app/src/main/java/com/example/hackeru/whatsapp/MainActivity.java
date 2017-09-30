package com.example.hackeru.whatsapp;

import android.os.Bundle;
import android.view.View;

import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.login_stuff.LoginActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!preferences.contains("email")){
            changeActivity(LoginActivity.class, true);
        }
        findViewById(R.id.activity_main_logout_button).setOnClickListener(this);

    }

    /**
     * Logout operation...
     * @param v
     */
    @Override
    public void onClick(View v) {
        editor.clear(); // delete all data from shared prefs...
        editor.commit();
        changeActivity(LoginActivity.class, true);
    }
}
