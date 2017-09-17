package com.example.hackeru.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String one = "{\"name\":\"Maayan Politzer\", \"age\":31, \"parents\":{\"mom\":\"Tova\", \"dad\":\"Menache\"}}";
        String two = "[{\"account\":7,\"balance\":500},{\"account\":46,\"balance\":-4500},{\"account\":156,\"balance\":9218}]";

        String line = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        while((line = reader.readLine()) != null){
            sb.append(line);
        }

        /*
        // one - json object.
        try {
            JSONObject object = new JSONObject(one);
            JSONObject parents = object.getJSONObject("parents");
            String mom = parents.getString("mom");
            Log.d("*************", "onCreate: " + mom);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        */

        // two - json array.
        int totalBalance = 0;
        try {
            JSONArray array = new JSONArray(two);
            for(int i = 0; i < array.length(); i++){
                JSONObject object = array.getJSONObject(i);
                totalBalance += object.getInt("balance");
            }
            Log.d("TAG", "balance: " + totalBalance);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
