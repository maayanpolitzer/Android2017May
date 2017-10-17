package example.com.fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_main_frame_layout, new FirstFragment())
                .commit();
    }

    public void changeFragment(View view) {
        getFragmentManager()
                .beginTransaction()
                .addToBackStack(null)
                .replace(R.id.activity_main_frame_layout, new SecondFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStack();
        }else {
            super.onBackPressed();  // finish();
        }
    }
}
