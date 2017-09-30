package com.example.hackeru.whatsapp.login_stuff;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackeru.whatsapp.MainActivity;
import com.example.hackeru.whatsapp.R;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.infrastructure.Validation;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private EditText emailET, passwordET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViews();
    }

    private void findViews() {
        emailET = (EditText) findViewById(R.id.activity_login_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_login_password_edit_text);

        findViewById(R.id.activity_login_login_button).setOnClickListener(this);
        findViewById(R.id.activity_login_register_text_view).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.activity_login_login_button:
                login();
                break;
            case R.id.activity_login_register_text_view:
                moveToRegister();
                break;
        }
    }

    private void login(){
        String email = Validation.validateEmail(emailET);
        String password = Validation.validatePassword(passwordET);
        if(email != null && password != null){
            // TODO: 9/25/2017 connect the server...
            if(email.equals("maayan@gmail.com") && password.equals("123456")){  // fake data...
                editor.putString("email", email);
                editor.putString("password", password);
                editor.commit();
                changeActivity(MainActivity.class, true);
            }else{
                Toast.makeText(this, "Wrong inputs...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void moveToRegister(){
        changeActivity(RegisterActivity.class, true);
    }


}
