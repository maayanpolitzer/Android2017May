package example.com.clicksgame;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class WallOfFameActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wall_of_fame);

        DBOpenHelper helper = new DBOpenHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        //ArrayList<String> scores = new ArrayList<>();

        Cursor cursor = db.query(
                DBOpenHelper.TABLE_NAME,
                new String[]{DBOpenHelper.COL_ID, DBOpenHelper.COL_NAME, DBOpenHelper.COL_SCORE},
                null, //DBOpenHelper.COL_SCORE + " > ? OR " + DBOpenHelper.COL_SECONDS + " != ?",
                null, //new String[]{"6", "5"},
                null,
                null,
                DBOpenHelper.COL_SCORE + " DESC",
                "5"
        );
        /*
        if(cursor != null && cursor.moveToFirst()){
            do {
                String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_NAME));
                int score = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COL_SCORE));
                //scores.add(name + ": " + score);  // from memory...
            }while(cursor.moveToNext());
        }
        */

        ListView listView = (ListView) findViewById(R.id.listView);
        /*
        // from memory.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                scores
        );
        */

        MyAdapter adapter = new MyAdapter(this, cursor);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "id: " + id , Toast.LENGTH_SHORT).show();
    }
}
