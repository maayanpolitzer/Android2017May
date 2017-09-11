package com.example.hackeru.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AddContactActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup images,colors;
    private EditText nameET, phoneET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        findViewById(R.id.saveBtn).setOnClickListener(this);

        images = (RadioGroup) findViewById(R.id.imagesGroup);
        colors = (RadioGroup) findViewById(R.id.colorsGroup);

        nameET = (EditText) findViewById(R.id.name_edit_text);
        phoneET = (EditText) findViewById(R.id.phone_edit_text);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.putExtra("name", nameET.getText().toString().trim());
        intent.putExtra("phone", phoneET.getText().toString());
        intent.putExtra("image", getImage());
        intent.putExtra("color", getColor());
        /*
        Contact contact = new Contact(nameET.getText().toString().trim(), phoneET.getText().toString(), getImage(), getColor());
        intent.putExtra("contact", contact);
        */
        setResult(RESULT_OK, intent);
        finish();
    }

    private int getColor() {
        int color;
        switch(colors.getCheckedRadioButtonId()){
            case R.id.color_one:
                color = R.color.red;
                break;
            case R.id.color_two:
                color = R.color.green;
                break;
            default:
                color = R.color.blue;
        }
        return color;
    }

    private int getImage() {
        int image;
        switch(images.getCheckedRadioButtonId()){
            case R.id.image_one:
                image = android.R.drawable.ic_media_ff;
                break;
            case R.id.image_two:
                image = android.R.drawable.ic_menu_camera;
                break;
            default:
                image = android.R.drawable.ic_menu_directions;
        }
        return image;
    }
}
