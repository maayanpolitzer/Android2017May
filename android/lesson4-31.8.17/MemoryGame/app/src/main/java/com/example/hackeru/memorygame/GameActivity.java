package com.example.hackeru.memorygame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class GameActivity extends AppCompatActivity {

    private Level[] levels = {
            new Level(2,3),
            new Level(3,4),
            new Level(4,6)
    };

    private LinearLayout.LayoutParams rowParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 0, 1);
    private LinearLayout.LayoutParams colParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);   // hides the status bar
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // prevent the screen from turning off.
        getSupportActionBar().hide();   // hides the action bar.

        int level = getIntent().getIntExtra("LEVEL", 0);

        LinearLayout mainLayout = (LinearLayout) findViewById(R.id.activity_game_main_linear_layout);

        for(int i = 0; i < levels[level].getRows(); i++){
            LinearLayout row = new LinearLayout(this);
            //row.setOrientation(LinearLayout.HORIZONTAL);  // default...
            for(int j = 0; j < levels[level].getCols(); j++){
                ImageView card = new ImageView(this);
                card.setLayoutParams(colParams);
                card.setImageResource(R.drawable.card);
                row.addView(card);
            }
            row.setLayoutParams(rowParams);
            mainLayout.addView(row);
        }

    }
}
