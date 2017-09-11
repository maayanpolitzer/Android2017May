package com.example.hackeru.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int ADD_CONTACT_REQUEST_CODE = 1;
    private ArrayList<Contact> contacts;
    private ContactsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contacts = new ArrayList<>();
        //contacts.add(new Contact("Maayan", "0521234567", android.R.drawable.ic_lock_lock, R.color.green));
        //contacts.add(new Contact("Yossi", "54679", android.R.drawable.ic_dialog_info, R.color.red));

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setEmptyView(findViewById(R.id.emptyList));

        adapter = new ContactsAdapter(this, contacts);

        listView.setAdapter(adapter);

        findViewById(R.id.addBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddContactActivity.class);
                startActivityForResult(intent, ADD_CONTACT_REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == ADD_CONTACT_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                String phone = data.getStringExtra("phone");
                int image = data.getIntExtra("image", 0);
                int color = data.getIntExtra("color", 0);
                contacts.add(new Contact(name, phone, image, color));
                /*
                Contact contact = (Contact) data.getSerializableExtra("contact");
                contacts.add(contact);
                */
                adapter.notifyDataSetChanged();
            }
        }
    }
}
