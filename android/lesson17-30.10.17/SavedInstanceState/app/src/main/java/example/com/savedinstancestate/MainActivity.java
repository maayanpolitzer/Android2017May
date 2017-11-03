package example.com.savedinstancestate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.text_view);

    }

    public void updateCounter(View view) {
        textView.setText(String.valueOf(++counter));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // this method will be called before orientation changed.
        // save your data.
        outState.putInt("COUNTER", counter);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // this method will be called after the activity created ONLY if you've saved your data.
        // get your data
        counter = savedInstanceState.getInt("COUNTER");
        textView.setText(String.valueOf(counter));
    }
}
