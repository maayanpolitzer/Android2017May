package com.example.hackeru.whatsapp.main;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hackeru.whatsapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hackeru on 11/2/2017.
 */

public class ZoharAdapter extends BaseAdapter{

    private JSONArray array;
    private Context context;

    public ZoharAdapter(Context context, JSONArray array){
        this.context = context;
        this.array = array;
    }

    @Override
    public int getCount() {
        return array.length();
    }

    @Override
    public JSONObject getItem(int position) {
        try {
            return array.getJSONObject(position);
        } catch (JSONException e) {
            return null;
        }
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.user_list_item, parent, false);
            textView = (TextView) convertView.findViewById(R.id.user_list_item_text_view);
            convertView.setTag(textView);
        }else{
            textView = (TextView) convertView.getTag();
        }
        try {
            textView.setText(array.getJSONObject(position).getString("username"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return convertView;
    }
}
