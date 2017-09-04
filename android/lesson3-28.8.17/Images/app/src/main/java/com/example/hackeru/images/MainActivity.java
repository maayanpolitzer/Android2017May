package com.example.hackeru.images;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private boolean isDog = true;

    private int[] images = {
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.german_wurst
    };
    private int counter;    // default is 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.image);
        imageView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        counter++;
        if(counter == images.length){
            counter = 0;
        }
        imageView.setImageResource(images[counter]);
        /*
        switch (counter){
            case 0:
                imageView.setImageResource(R.drawable.cat);
                break;
            case 1:
                imageView.setImageResource(R.drawable.dog);
                break;
            case 2:
                imageView.setImageResource(R.drawable.german_wurst);
                break;
            default:
                String data = getString(R.string.error);
                Toast.makeText(this, data + ": " + counter, Toast.LENGTH_LONG).show();
        }
        // two images... (using boolean)
        imageView.setImageResource(isDog ? R.drawable.german_wurst : R.drawable.dog);
        isDog = !isDog;
        */
        /*
        if(isDog){
            imageView.setImageResource(R.drawable.german_wurst);
            isDog = false;
        }else{
            imageView.setImageResource(R.drawable.dog);
            isDog = true;
        }
        */
    }

    /*
    public void changeImage(View view) {
        ImageView imageView = (ImageView) view;
        imageView.setImageResource(R.drawable.german_wurst);
    }
    */
}
