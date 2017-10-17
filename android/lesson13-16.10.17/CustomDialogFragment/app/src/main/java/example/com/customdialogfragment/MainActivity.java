package example.com.customdialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnChangeNameListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        String name = textView.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("name", name);

        MyDialog dialog = new MyDialog();
        dialog.setArguments(bundle);
        dialog.show(getFragmentManager(),null);
    }

    @Override
    public void changeDisplay(String name){
        textView.setText(name);
    }
}
