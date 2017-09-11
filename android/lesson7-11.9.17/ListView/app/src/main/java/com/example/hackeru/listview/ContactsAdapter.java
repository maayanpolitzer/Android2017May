package com.example.hackeru.listview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by hackeru on 9/11/2017.
 */

class ContactsAdapter extends ArrayAdapter {

    private Context context;
    private ArrayList<Contact> contacts;

    public ContactsAdapter(Context context, ArrayList<Contact> contacts){
        super(context, R.layout.list_item, contacts);
        this.context = context;
        this.contacts = contacts;
    }

    private class ViewHolder {
        ImageView avatar;
        View dialer;    // we are NOT going to change it's src - so View object is good! (we can click on any View).
        TextView name;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if(convertView == null){
            // new view... inflate!
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, null);
            // create ViewHolder object.
            holder = new ViewHolder();
            // get pointers from convertView.
            holder.avatar = (ImageView) convertView.findViewById(R.id.list_item_image);
            holder.dialer = convertView.findViewById(R.id.list_item_dialer);
            holder.name = (TextView) convertView.findViewById(R.id.list_item_name);
            // setTag().
            convertView.setTag(holder);
        }else{
            // get tag().
            holder = (ViewHolder) convertView.getTag();
        }
        final Contact contact = contacts.get(position);
        holder.avatar.setImageResource(contact.getImage());
        holder.name.setText(contact.getName());
        // TODO: 9/11/2017 fix colors!!!
        holder.name.setTextColor(context.getResources().getColor(contact.getColor()));
        // TODO: 9/11/2017 dialer imageView...
        holder.dialer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + contact.getPhone()));
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
