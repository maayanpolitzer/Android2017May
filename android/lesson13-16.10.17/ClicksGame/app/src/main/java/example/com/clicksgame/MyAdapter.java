package example.com.clicksgame;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

/**
 * Created by hackeru on 10/16/2017.
 */

public class MyAdapter extends CursorAdapter {

    public MyAdapter(Context context, Cursor cursor){
        super(context, cursor, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.list_item_text_view);
        view.setTag(textView);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView textView = (TextView) view.getTag();
        String name = cursor.getString(cursor.getColumnIndex(DBOpenHelper.COL_NAME));
        int score = cursor.getInt(cursor.getColumnIndex(DBOpenHelper.COL_SCORE));
        textView.setText(name + ": " + score);
    }
}
