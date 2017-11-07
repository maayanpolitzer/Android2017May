package com.example.hackeru.whatsapp.main;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hackeru.whatsapp.R;
import com.example.hackeru.whatsapp.db.DataSource;
import com.example.hackeru.whatsapp.infrastructure.BaseActivity;
import com.example.hackeru.whatsapp.models.Message;
import com.example.hackeru.whatsapp.server_connections.HttpMethod;
import com.example.hackeru.whatsapp.server_connections.HttpRequest;
import com.example.hackeru.whatsapp.server_connections.OnServerResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class ChatActivity extends BaseActivity implements View.OnClickListener {

    private LinearLayout messagesLayout;
    private EditText messageET;
    private int recipientID;
    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent.getIntExtra("user_id",-1) == recipientID) {
                String message = intent.getStringExtra("message");
                boolean incoming = intent.getBooleanExtra("incoming", false);
                displayMessage(message, incoming);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        String username = getIntent().getStringExtra("username");

        recipientID = getIntent().getIntExtra("userID", 0);

        getSupportActionBar().setTitle("Chat with " + username);

        messagesLayout = (LinearLayout) findViewById(R.id.activity_chat_messages_linear_layout);
        messageET = (EditText) findViewById(R.id.activity_chat_message_edit_text);
        findViewById(R.id.activity_chat_send_image_view).setOnClickListener(this);

        List<Message> messages = new DataSource(this).getMessages(recipientID);
        for(Message message : messages){
            displayMessage(message.getContent(), message.isIncoming());
        }
        // TODO: 11/2/2017 scroll to bottom of scrollView...

    }

    public void displayMessage(String content, boolean isIncomingMessage){
        View view = getLayoutInflater().inflate(isIncomingMessage ? R.layout.message_in : R.layout.message_out, null);
        TextView textView = (TextView) view.findViewById(R.id.message_text_view);
        textView.setText(content);
        messagesLayout.addView(view);
    }

    @Override
    public void onClick(View v) {
        String message = messageET.getText().toString().trim();
        if(!message.isEmpty()){
            // TODO: 11/2/2017 send message!
            JSONObject data = new JSONObject();
            try{
                data.put("action",4);
                data.put("user_id", preferences.getInt("user_id", -1));
                data.put("to_id", recipientID);
                data.put("message",message);
            }catch (JSONException e){
                e.printStackTrace();
            }
            new DataSource(ChatActivity.this).saveMessage(data);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, new IntentFilter("99fm"));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(receiver);
    }
}
