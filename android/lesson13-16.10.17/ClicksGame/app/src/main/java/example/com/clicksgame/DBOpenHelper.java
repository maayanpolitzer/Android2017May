package example.com.clicksgame;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 10/16/2017.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "database";
    private static final int DB_VERSION = 1;

    public static final String TABLE_NAME = "scores";
    public static final String COL_ID = "_id";
    public static final String COL_NAME = "name";
    public static final String COL_SCORE = "score";
    public static final String COL_SECONDS = "seconds";

    private static final String CREATE_TABLE_COMMAND = "CREATE TABLE " + TABLE_NAME + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_SCORE + " INTEGER, " +
            COL_SECONDS + " INTEGER)";

    public DBOpenHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_COMMAND);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
