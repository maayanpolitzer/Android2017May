package com.example.hackeru.whatsapp.db;

import android.database.Cursor;

import com.example.hackeru.whatsapp.infrastructure.Message;

import java.util.List;

/**
 * Created by hackeru on 10/30/2017.
 */

public class DataSource {

    // TODO: 10/30/2017 make this class singleton.

    /**
     * method that will return a cursor with all the users that already had a chat with.
     * @return cursor object.
     */
    public Cursor getUsers(){
        return null;
    }

    /**
     * get all messages from/to specific user
     * @param user_id
     * @return list with message objects
     */
    public List<Message> getMessages(int user_id){
        return null;
    }

    /**
     * insert a new message to db.
     * if this is incoming message notify the user (notification/update list).
     *
     * @param content the message content
     * @param user_id
     * @param incoming boolean : true - incoming, false - outgoing.
     */
    public void insertNewMessage(String content, int user_id, boolean incoming){
        // TODO: 10/30/2017 update users table.
    }

    /**
     * method that will update / insert usersTable.
     * try to update - if return 0 need to insert.
     * if insert - get username from server.
     * @param user_id
     * @param incoming
     * @param username
     */
    private void updateUsersTable(int user_id, boolean incoming, String username){

    }



}
