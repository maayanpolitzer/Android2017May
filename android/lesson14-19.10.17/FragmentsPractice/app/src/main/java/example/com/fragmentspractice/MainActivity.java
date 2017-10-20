package example.com.fragmentspractice;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private MyFragment firstFragment;
    private MyFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = createFragment("#00ff00");
        secondFragment = createFragment("#ff0000");

        RadioGroup group = (RadioGroup) findViewById(R.id.group);
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                displayFragment(checkedId == R.id.first ? firstFragment : secondFragment);
            }
        });
        displayFragment(firstFragment);
    }

    private MyFragment createFragment(String backgroundColor){
        MyFragment f = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Rami", backgroundColor);
        f.setArguments(bundle);
        return f;
    }

    private void displayFragment(MyFragment fragment){
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

}
