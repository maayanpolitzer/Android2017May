package example.com.clicksgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.activity_main_play_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(GameActivity.class);
            }
        });

        findViewById(R.id.activity_main_settings_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(SettingsActivity.class);
            }
        });

        findViewById(R.id.activity_main_wall_of_fame_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity(WallOfFameActivity.class);
            }
        });

    }

    private void changeActivity(Class targetActivity){
        startActivity(new Intent(this, targetActivity));
    }

}
