package com.example.hackeru.whatsapp;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.login_stuff.LoginActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!preferences.contains("email")){
            changeActivity(LoginActivity.class, true);
            return;
        }

        findViewById(R.id.activity_main_logout_button).setOnClickListener(this);


    }

    /**
     * Logout operation...
     * @param v
     */
    @Override
    public void onClick(View v) {
        logout();
    }

    private void logout() {
        editor.clear(); // delete all data from shared prefs...
        editor.commit();
        changeActivity(LoginActivity.class, true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_profile:
                Toast.makeText(this, "profile", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_logout:
                logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
