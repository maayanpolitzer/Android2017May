package com.example.hackeru.whatsapp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 10/30/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper{

    private static final String DB_NAME = "database";
    private static final int DB_VERSION = 1;

    public static class UsersTable{
        public static final String TABLE_NAME = "users";
        public static final String COL_ID = "_id";  // user_id.
        public static final String COL_NAME = "name";
        public static final String COL_LAST_MESSAGE = "last_message";
        private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER UNIQUE, " +
                COL_NAME + " TEXT, " +
                COL_LAST_MESSAGE + " INTEGER)";
    }

    public static class MessagesTable{
        public static final String TABLE_NAME = "messages";
        public static final String COL_ID = "_id";  // user_id.
        public static final String COL_MESSAGE = "message";
        public static final String COL_INCOMING = "incoming";   // 1 - incoming message, 0 - outgoing message
        private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_NAME + " (" +
                COL_ID + " INTEGER , " +
                COL_MESSAGE + " TEXT, " +
                COL_INCOMING + " INTEGER)";
    }

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsersTable.CREATE_COMMAND);
        db.execSQL(MessagesTable.CREATE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
