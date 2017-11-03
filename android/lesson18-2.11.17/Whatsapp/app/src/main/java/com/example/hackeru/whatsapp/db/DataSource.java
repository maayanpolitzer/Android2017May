package com.example.hackeru.whatsapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.hackeru.whatsapp.main.ChatActivity;
import com.example.hackeru.whatsapp.models.Message;
import com.example.hackeru.whatsapp.models.User;
import com.example.hackeru.whatsapp.server_connections.HttpMethod;
import com.example.hackeru.whatsapp.server_connections.HttpRequest;
import com.example.hackeru.whatsapp.server_connections.OnServerResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by hackeru on 10/30/2017.
 */

public class DataSource {

    private static final int SEND_MESSAGE = 4;
    private SQLiteDatabase db;
    private Context context;

    public DataSource(Context context){
        DBOpenHelper helper = new DBOpenHelper(context);
        db = helper.getWritableDatabase();
        this.context = context;
    }

    // TODO: 10/30/2017 make this class singleton.

    public void saveMessage(final JSONObject object){
        new HttpRequest(HttpMethod.POST, object, new OnServerResponseListener() {
            @Override
            public void onSuccess(JSONObject result) {
                try {
                    if(result.getBoolean("response")){
                        Log.d("TAG", "30: " + result);
                        String message;
                        int recipientID;
                        boolean incoming;
                        if(object.getInt("action") == SEND_MESSAGE){
                            // send message
                            message = object.getString("message");
                            recipientID = object.getInt("to_id");
                            incoming = false;
                        }else{
                            // get message
                            message = result.getString("message");
                            recipientID = result.getInt("sender_id");
                            incoming = true;
                        }
                        insertNewMessage(message, recipientID, incoming);
                        // TODO: 11/2/2017 update activity...
                        Intent intent = new Intent("99fm");
                        intent.putExtra("incoming", incoming);
                        intent.putExtra("message", message);
                        intent.putExtra("user_id", recipientID);
                        context.sendBroadcast(intent);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(String error) {

            }
        }).start();
    }

    /**
     * method that will return a list with all the users that already had a chat with.
     * @return list of users ordered by the last message time.
     */
    public List<User> getUsers(){
        Cursor cursor = db.query(
                DBOpenHelper.UsersTable.TABLE_NAME,
                new String[]{DBOpenHelper.UsersTable.COL_ID, DBOpenHelper.UsersTable.COL_NAME},
                null,
                null,
                null,
                null,
                DBOpenHelper.UsersTable.COL_LAST_MESSAGE + " DESC"
        );
        List<User> users = new ArrayList<>();
        if(cursor != null && cursor.moveToFirst()){
            do{
                String username = cursor.getString(cursor.getColumnIndex(DBOpenHelper.UsersTable.COL_NAME));
                int id = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.UsersTable.COL_ID));
                users.add(new User(id, username));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return users;
    }

    /**
     * get all messages from/to specific user
     * @param user_id
     * @return list with message objects
     */
    public List<Message> getMessages(int user_id){
        Cursor cursor = db.query(
                DBOpenHelper.MessagesTable.TABLE_NAME,
                new String[]{DBOpenHelper.MessagesTable.COL_MESSAGE, DBOpenHelper.MessagesTable.COL_INCOMING},
                DBOpenHelper.MessagesTable.COL_ID + " = ?",
                new String[]{String.valueOf(user_id)},
                null,
                null,
                null
        );
        List<Message> messages = new ArrayList<>();
        if(cursor != null && cursor.moveToFirst()){
            do{
                String message = cursor.getString(cursor.getColumnIndex(DBOpenHelper.MessagesTable.COL_MESSAGE));
                int incoming = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.MessagesTable.COL_INCOMING));
                messages.add(new Message(message, incoming == 1));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return messages;
    }

    /**
     * insert a new message to db.
     *
     * @param content the message content
     * @param user_id
     * @param incoming boolean : true - incoming, false - outgoing.
     */
    private void insertNewMessage(String content, int user_id, boolean incoming){
        ContentValues values = new ContentValues();
        values.put(DBOpenHelper.MessagesTable.COL_ID, user_id);
        values.put(DBOpenHelper.MessagesTable.COL_MESSAGE, content);
        values.put(DBOpenHelper.MessagesTable.COL_INCOMING, incoming ? 1 : 0);
        db.insert(
                DBOpenHelper.MessagesTable.TABLE_NAME,
                null,
                values
        );
        Log.d("TAG", "2");
        updateUsersTable(user_id);
    }

    /**
     * method that will update / insert usersTable.
     * try to update - if return 0 need to insert.
     * if insert - get username from server.
     * @param user_id
     */
    private void updateUsersTable(final int user_id){
        final ContentValues values = new ContentValues();
        values.put(DBOpenHelper.UsersTable.COL_LAST_MESSAGE, Calendar.getInstance().getTimeInMillis());
        int rowsAffected = db.update(
                DBOpenHelper.UsersTable.TABLE_NAME,
                values,
                DBOpenHelper.UsersTable.COL_ID + " = ?",
                new String[]{String.valueOf(user_id)}
        );
        if(rowsAffected == 0){
            // need to insert new user...
            JSONObject request = new JSONObject();
            try {
                request.put("action", 5);
                request.put("user_id", user_id);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            new HttpRequest(HttpMethod.POST, request, new OnServerResponseListener() {
                @Override
                public void onSuccess(JSONObject data) {
                    Log.d("TAG", "10: " + data);
                    try {
                        if(data.getBoolean("response")){
                            String username = data.getString("username");
                            values.put(DBOpenHelper.UsersTable.COL_NAME, username);
                            values.put(DBOpenHelper.UsersTable.COL_ID, user_id);
                            db.insert(
                                    DBOpenHelper.UsersTable.TABLE_NAME,
                                    null,
                                    values
                            );
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(String error) {

                }
            }).start();
        }
    }

}
