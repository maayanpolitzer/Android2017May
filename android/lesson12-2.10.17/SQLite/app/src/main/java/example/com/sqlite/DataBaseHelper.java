package example.com.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by hackeru on 10/2/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "kimDB";
    private static final int DB_VERSION = 1;

    public static final String TABLE_USERS = "users";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";   // not sure if ok...
    public static final String COL_AGE = "age";
    public static final String COL_HEIGHT = "height";

    private static final String CREATE_COMMAND = "CREATE TABLE " + TABLE_USERS + " (" +
            COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COL_NAME + " TEXT, " +
            COL_AGE + " INTEGER, " +
            COL_HEIGHT + " REAL" +
            ")";

    public DataBaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables...
        db.execSQL(CREATE_COMMAND);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
