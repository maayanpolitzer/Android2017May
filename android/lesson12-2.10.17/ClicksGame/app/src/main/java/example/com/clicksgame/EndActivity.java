package example.com.clicksgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EndActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText nameET;
    private int clicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        TextView scoreTV = (TextView) findViewById(R.id.activity_end_score_text_view);
        nameET = (EditText) findViewById(R.id.activity_end_name_edit_text);
        findViewById(R.id.activity_end_save_button).setOnClickListener(this);

        clicks = getIntent().getIntExtra("score", 0);

        scoreTV.setText(clicks + "");

    }

    @Override
    public void onClick(View v) {
        String name = nameET.getText().toString().trim();
        int time = getSharedPreferences("MaayanPrefs", MODE_PRIVATE).getInt("length", 5);
        int score = clicks / time;
        saveData(name, score);
    }

    private void saveData(String name, int score){
        
    }
}
