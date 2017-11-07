package com.example.hackeru.whatsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.hackeru.whatsapp.db.DataSource;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.login_stuff.LoginActivity;
import com.example.hackeru.whatsapp.main.ChatActivity;
import com.example.hackeru.whatsapp.main.UsersActivity;
import com.example.hackeru.whatsapp.models.User;

import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    //https://minhaskamal.github.io/DownGit/#/home
    private List<User> users;
    private boolean listening;
    private ArrayAdapter<User> adapter;
    private ListView listView;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            adapter.clear();
            adapter.addAll(new DataSource(context).getUsers());
            adapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!preferences.contains("email")){
            changeActivity(LoginActivity.class, true);
            return;
        }
        findViewById(R.id.startNewChat).setOnClickListener(this);

        listView = (ListView) findViewById(R.id.activity_main_users_list_view);
        users = new DataSource(this).getUsers();
        adapter = new ArrayAdapter<User>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

        registerReceiver(receiver, new IntentFilter("99fm"));
        listening = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(listening) {
            listening = false;
            unregisterReceiver(receiver);
        }
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

    @Override
    public void onClick(View v) {
        startActivity(new Intent(this, UsersActivity.class));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("username", users.get(position).getUsername());
        intent.putExtra("userID", users.get(position).getUserID());
        startActivity(intent);
    }
}
