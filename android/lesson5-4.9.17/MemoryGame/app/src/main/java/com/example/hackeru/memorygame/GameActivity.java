package com.example.hackeru.memorygame;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private Level[] levels = {
            new Level(2,3),
            new Level(3,4),
            new Level(4,6)
    };

    private int[] images = {
            R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six, R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten, R.drawable.eleven, R.drawable.twelve
    };

    private int[] monsters;

    private int firstCardImage;
    private int tagCounter;
    private int counter;
    private int rightGuesses;
    private ImageView firstCard;

    private Handler handler;

    private boolean working;

    private long start;

    private LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
    private LinearLayout.LayoutParams colParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // prevent the screen from turning off.
        getSupportActionBar().hide();   // hides the action bar.

        handler = new Handler();

        int level = getIntent().getIntExtra("LEVEL", 0);

        initMonsters(level);

        shuffle();

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_game_main_linear_layout);

        for(int i = 0; i < levels[level].getRows(); i++){
            LinearLayout row = new LinearLayout(this);
            //row.setOrientation(LinearLayout.HORIZONTAL);  // default...
            for(int j = 0; j < levels[level].getCols(); j++){
                ImageView card = new ImageView(this);
                card.setImageResource(R.drawable.card);
                card.setOnClickListener(this);
                //card.setTag(i * levels[level].getCols() + j);
                card.setTag(tagCounter++);
                card.setLayoutParams(colParams);
                row.addView(card);
            }
            row.setLayoutParams(rowParams);
            mainLayout.addView(row);
        }
    }

    private void initMonsters(int level){
        monsters = new int[levels[level].getCols() * levels[level].getRows()];
        int counter = 0;
        for (int i = 0; i < monsters.length; i += 2){
            monsters[i] = images[counter];
            monsters[i+1] = images[counter++];
        }
    }

    private void shuffle() {
        Random random = new Random();
        int temp,randomNumber;
        for(int i = 0; i < monsters.length; i++){
            temp = monsters[i];
            randomNumber = random.nextInt(monsters.length);
            monsters[i] = monsters[randomNumber];
            monsters[randomNumber] = temp;
        }
    }

    @Override
    public void onClick(View v) {
        if(!working) {
            counter++;
            if(counter == 1){
                start = System.currentTimeMillis();
            }
            int tag = Integer.parseInt(v.getTag().toString());
            final ImageView clickedCard = (ImageView) v;
            clickedCard.setImageResource(monsters[tag]);
            if (counter % 2 == 0) {
                working = true;
                // even card - > need to check previous card && this card.
                if (firstCardImage == monsters[tag]) {
                    // card are the same!
                    clickedCard.setOnClickListener(null);
                    rightGuesses++;
                    if (rightGuesses == tagCounter / 2) {
                        // game over.
                        long end = System.currentTimeMillis();
                        Intent intent = new Intent(this, EndActivity.class);
                        intent.putExtra("TIME", end-start);
                        intent.putExtra("COUNTER", counter);
                        startActivity(intent);
                        finish();
                    }
                    working = false;
                } else {
                    // different cards...
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            firstCard.setImageResource(R.drawable.card);
                            clickedCard.setImageResource(R.drawable.card);
                            working = false;
                        }
                    }, 1500);
                    firstCard.setOnClickListener(this);
                }
            } else {
                // odd card.
                firstCard = clickedCard;
                firstCardImage = monsters[tag];
                clickedCard.setOnClickListener(null);
            }
        }
    }
}
