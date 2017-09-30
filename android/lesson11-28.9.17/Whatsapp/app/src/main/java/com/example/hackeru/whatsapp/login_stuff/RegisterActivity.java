package com.example.hackeru.whatsapp.login_stuff;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackeru.whatsapp.MainActivity;
import com.example.hackeru.whatsapp.R;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.infrastructure.Validation;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private EditText emailET, passwordET, conPasswordET;
    private View mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // display the back button in the actionbar. id:android.R.id.home

        findViews();

    }

    private void findViews(){
        emailET = (EditText) findViewById(R.id.activity_register_email_edit_text);
        passwordET = (EditText) findViewById(R.id.activity_register_password_edit_text);
        conPasswordET = (EditText) findViewById(R.id.activity_register_confirm_password_edit_text);
        mainLayout = findViewById(R.id.activity_register_main_relative_layout);
        findViewById(R.id.activity_register_sign_up_button).setOnClickListener(this);
    }

    @Override
    public void onBackPressed() {
        changeActivity(LoginActivity.class, true);
    }

    // catches clicks on buttons in actionbar.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * sign up operation....
     * @param v
     */
    @Override
    public void onClick(View v) {
        String email = Validation.validateEmail(emailET);
        String password = Validation.validatePassword(passwordET);
        boolean matchPasswords = Validation.isPasswordEquals(conPasswordET, password);
        if(email != null && password != null && matchPasswords){
            // TODO: 9/28/2017 send data to server to create a new user
            editor.putString("email", email);
            editor.putString("password", password);
            editor.commit();    // blocking method... the code freeze!
            changeActivity(MainActivity.class, true);
        }else{
            Snackbar.make(mainLayout, "Error", Snackbar.LENGTH_SHORT).show();
        }
        /*

        if(email != null & password != null & Validation.isPasswordEquals(conPasswordET, password)){
            Toast.makeText(this, "perform sign up...", Toast.LENGTH_SHORT).show();
        }
        */
    }


}
