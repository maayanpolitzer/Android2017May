package com.example.hackeru.whatsapp.fcm;

import android.os.Handler;
import android.util.Log;

import com.example.hackeru.whatsapp.db.DataSource;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 11/6/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private Handler handler;

    public MyFirebaseMessagingService(){
        handler = new Handler();
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        int message_id = Integer.parseInt(remoteMessage.getData().get("message_id"));
        final JSONObject obj = new JSONObject();
        try {
            obj.put("action",6);
            obj.put("user_id",getSharedPreferences("PREFS_FILE_NAME", MODE_PRIVATE).getInt("user_id", 0));
            obj.put("message_id",message_id);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                new DataSource(MyFirebaseMessagingService.this).saveMessage(obj);
            }
        });
        /*

        */
        /*
        Log.d("TAG", "incoming message!!!");

        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d("TAG", "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        /*
        if (remoteMessage.getData().size() > 0) {
            Log.d("TAG", "Message data payload: " + remoteMessage.getData());
        }

        Log.d("TAG", remoteMessage.getData().toString());

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d("TAG", "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        */
    }

}
