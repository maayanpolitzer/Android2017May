package com.example.hackeru.customlist;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 9/7/2017.
 */

public class DimaAdapter extends ArrayAdapter {

    private LayoutInflater inflater;
    private ArrayList<Integer> numbers;

    public DimaAdapter(Context context, ArrayList<Integer> numbers) {
        super(context, R.layout.list_item, numbers);
        inflater = LayoutInflater.from(context);
        this.numbers = numbers;
    }

    private class ViewHolder {
        TextView titleTV;
        TextView currencyTV;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.list_item, null);
            holder.titleTV = (TextView) convertView.findViewById(R.id.text_view);
            holder.currencyTV = (TextView) convertView.findViewById(R.id.currency_text_view);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        holder.titleTV.setText(numbers.get(position) + "");
        holder.currencyTV.setText(numbers.get(position) % 2 == 0 ? "Shekels" : "$$$");
        return convertView;
    }
}
