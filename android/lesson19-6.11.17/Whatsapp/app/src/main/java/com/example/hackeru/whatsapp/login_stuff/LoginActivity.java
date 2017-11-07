package com.example.hackeru.whatsapp.login_stuff;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

public class LoginActivity extends BaseActivity implements View.OnClickListener, OnServerResponseListener {

    private EditText emailET, passwordET;
    private String email,password;

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
        email = Validation.validateEmail(emailET);
        password = Validation.validatePassword(passwordET);
        if(email != null && password != null){
            // TODO: 9/25/2017 connect the server...
            JSONObject object = new JSONObject();
            try {
                object.put("action",1);
                object.put("email", email);
                object.put("password", password);
                object.put("token", preferences.getString("token", null));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new HttpRequest(HttpMethod.POST, object, this).start();
        }
    }

    private void moveToRegister(){
        changeActivity(RegisterActivity.class, true);
    }


    @Override
    public void onSuccess(JSONObject data) {
        try {
            int userID = data.getInt("user_id");
            if(userID == -1){
                onFailure("No such user");
            }else{
                editor.putString("email", email);
                editor.putString("password", password);
                editor.putInt("user_id", userID);
                editor.commit();
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
