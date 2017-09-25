package com.example.hackeru.whatsapp.login_stuff;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.BaseAdapter;

import com.example.hackeru.whatsapp.R;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;

public class RegisterActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    public void onBackPressed() {
        changeActivity(LoginActivity.class, true);
    }
}
