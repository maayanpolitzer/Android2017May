package com.example.hackeru.whatsapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hackeru.whatsapp.R;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.server_connections.HttpMethod;
import com.example.hackeru.whatsapp.server_connections.HttpRequest;
import com.example.hackeru.whatsapp.server_connections.OnServerResponseListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UsersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        final ListView listView = (ListView) findViewById(R.id.activity_users_list_view);

        JSONObject data = new JSONObject();
        try {
            data.put("action", 3);
            data.put("user_id", preferences.getInt("user_id", -1));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        new HttpRequest(HttpMethod.POST, data, new OnServerResponseListener() {
            @Override
            public void onSuccess(JSONObject data) {
                try {
                    final JSONArray array = data.getJSONArray("users");
                    ZoharAdapter adapter = new ZoharAdapter(UsersActivity.this, array);
                    listView.setAdapter(adapter);
                    listView.setEmptyView(findViewById(R.id.empty));
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            try {
                                Intent intent = new Intent(UsersActivity.this, ChatActivity.class);
                                intent.putExtra("userID", array.getJSONObject(position).getInt("user_id"));
                                intent.putExtra("username", array.getJSONObject(position).getString("username"));
                                startActivity(intent);
                                finish();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                    /*
                    final List<User> users = new ArrayList<>();
                    for(int i = 0;i < array.length(); i++){
                        users.add(new User(array.getJSONObject(i)));
                    }
                    // if you wish to Create an adapter and pass the JSONARRAY (array) - extend BaseAdapter.
                    ArrayAdapter<User> adapter = new ArrayAdapter<User>(UsersActivity.this, android.R.layout.simple_list_item_1, users);
                    listView.setAdapter(adapter);

                    */
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(UsersActivity.this, error, Toast.LENGTH_LONG).show();
            }
        }).start();


    }
}
