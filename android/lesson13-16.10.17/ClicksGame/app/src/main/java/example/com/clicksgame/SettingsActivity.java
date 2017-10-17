package example.com.clicksgame;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SettingsActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText lengthET;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        lengthET = (EditText) findViewById(R.id.activity_settings_time_edit_text);
        findViewById(R.id.activity_settings_save_button).setOnClickListener(this);

        preferences = getSharedPreferences("MaayanPrefs", MODE_PRIVATE);
        editor = preferences.edit();

        lengthET.setText(preferences.getInt("length", 5) + "");

    }

    @Override
    public void onClick(View v) {
        int time = Integer.parseInt(lengthET.getText().toString());
        editor.putInt("length", time);
        editor.apply();
        finish();
    }
}
