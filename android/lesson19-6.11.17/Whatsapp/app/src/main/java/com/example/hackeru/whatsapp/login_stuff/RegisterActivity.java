package com.example.hackeru.whatsapp.login_stuff;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hackeru.whatsapp.MainActivity;
import com.example.hackeru.whatsapp.R;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.infrastructure.Validation;
import com.example.hackeru.whatsapp.server_connections.HttpMethod;
import com.example.hackeru.whatsapp.server_connections.HttpRequest;
import com.example.hackeru.whatsapp.server_connections.OnServerResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends BaseActivity implements View.OnClickListener, OnServerResponseListener {

    private EditText usernameET, emailET, passwordET, conPasswordET;
    private View mainLayout;
    private String username,password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);  // display the back button in the actionbar. id:android.R.id.home

        findViews();

    }

    private void findViews(){
        usernameET = (EditText) findViewById(R.id.activity_register_username_edit_text);
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
        username = usernameET.getText().toString().trim();
        email = Validation.validateEmail(emailET);
        password = Validation.validatePassword(passwordET);
        boolean matchPasswords = Validation.isPasswordEquals(conPasswordET, password);
        if(email != null && password != null && matchPasswords){
            // TODO: 9/28/2017 send data to server to create a new user
            JSONObject data = new JSONObject();
            try{
                data.put("action", 2);
                data.put("email", email);
                data.put("password", password);
                data.put("username", username);
                data.put("token", preferences.getString("token", null));
            }catch (JSONException e){

            }
            new HttpRequest(HttpMethod.POST, data, this).start();
        }else{
            Snackbar.make(mainLayout, "Error", Snackbar.LENGTH_SHORT).show();
        }
        /*

        if(email != null & password != null & Validation.isPasswordEquals(conPasswordET, password)){
            Toast.makeText(this, "perform sign up...", Toast.LENGTH_SHORT).show();
        }
        */
    }


    @Override
    public void onSuccess(JSONObject data) {
        Log.d("TAG", data + "");
        try {
            int userID = data.getInt("user_id");
            if(userID == -1) {
                onFailure("Email already in use");
            }else{
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putInt("user_id", userID);
                editor.commit();    // blocking method... the code freeze!
                changeActivity(MainActivity.class, true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
