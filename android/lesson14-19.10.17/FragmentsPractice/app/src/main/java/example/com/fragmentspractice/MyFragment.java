package example.com.fragmentspractice;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by hackeru on 10/19/2017.
 */

public class MyFragment extends Fragment implements View.OnClickListener {

    private TextView textView;
    private View view;
    private int counter;
    private String color;

    public void setColor(String color){
        this.color = color;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        if(view == null) {
            Log.d("TAG", "inflate");

            view = inflater.inflate(R.layout.fragment_my, container, false);

            String rami = getArguments().getString("Rami");
            view.setBackgroundColor(Color.parseColor(rami));

            textView = (TextView) view.findViewById(R.id.text);
            view.findViewById(R.id.btn).setOnClickListener(this);
        }
        return view;

    }


    @Override
    public void onClick(View v) {
        textView.setText(++counter + "");
    }
}
