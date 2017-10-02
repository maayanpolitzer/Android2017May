package example.com.clicksgame;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView timeTV;
    private int time;
    private int counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        timeTV = (TextView) findViewById(R.id.activity_game_time_text_view);
        findViewById(R.id.activity_game_button).setOnClickListener(this);

        time = getSharedPreferences("MaayanPrefs", MODE_PRIVATE).getInt("length", 5);

        timeTV.setText(time + "");

    }

    @Override
    public void onClick(View v) {
        if(counter == -1){
            // start the game.
            new CountDownTimer(time * 1000, 1000){

                @Override
                public void onTick(long millisUntilFinished) {
                    time--;
                    timeTV.setText(time + "");
                }

                @Override
                public void onFinish() {
                    Intent intent = new Intent(GameActivity.this, EndActivity.class);
                    intent.putExtra("score", counter);
                    startActivity(intent);
                    finish();
                }
            }.start();
        }
        counter++;
    }
}
