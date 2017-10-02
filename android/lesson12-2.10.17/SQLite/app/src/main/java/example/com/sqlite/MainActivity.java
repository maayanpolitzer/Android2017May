package example.com.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DataBaseHelper helper = new DataBaseHelper(this);

        db = helper.getWritableDatabase();

        /*
        db.delete(
                DataBaseHelper.TABLE_USERS,
                "name > ? AND height > ?",
                new String[]{"Maayan", "1.70"}
        );
        */

        printData();

    }

    private void printData(){
        Cursor cursor = db.query(
                DataBaseHelper.TABLE_USERS,
                null, //new String[]{DataBaseHelper.COL_NAME, DataBaseHelper.COL_AGE},
                null, // "id > 2",// "id > ?",
                null, // null, // new String[]{2 + ""},
                null, // "country",
                null,
                null, //DataBaseHelper.COL_AGE + " DESC",
                "10"
        );
        if(cursor != null && cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DataBaseHelper.COL_ID));
                String name = cursor.getString(cursor.getColumnIndex(DataBaseHelper.COL_NAME));
                Log.d("Log", id + ": " + name);
            }while(cursor.moveToNext());
        }
    }

    private void insertData(String name, int age, double height){
        ContentValues values = new ContentValues();
        values.put(DataBaseHelper.COL_NAME, "Maayan");
        values.put(DataBaseHelper.COL_AGE, 31);
        values.put(DataBaseHelper.COL_HEIGHT, 1.92);

        db.insert(
                DataBaseHelper.TABLE_USERS,
                null,
                values
        );

        /*
        String name = "maayan";
        db.execSQL("INSERT INTO users (name,age,height) VALUES ('" + name + "',31,1.92)");
         */
    }

}
