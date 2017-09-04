package com.example.hackeru.tipcalculator;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private View percentLayout;
    private RadioGroup radioGroup;
    private TextView resultTV;
    private EditText billET, percentET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.activity_main_tip_options_radio_group);
        percentLayout = findViewById(R.id.activity_main_percent_linear_layout);
        billET = (EditText) findViewById(R.id.activity_main_bill_edit_text);
        percentET = (EditText) findViewById(R.id.activity_main_percent_edit_text);
        resultTV = (TextView) findViewById(R.id.activity_main_result_text_view);

        findViewById(R.id.activity_main_calculate_button).setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);


    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        percentLayout.setVisibility(checkedId == R.id.other_radio_button ? View.VISIBLE : View.INVISIBLE);
        /*
        if(checkedId == R.id.other_radio_button){
            // show layout...
            // percentET.requestFocus();
            // show virtual keyboard.
        }else{
            // hide layout...
        }
        */

    }

    @Override
    public void onClick(View v) {
        int checkedID = radioGroup.getCheckedRadioButtonId();
        String billData = billET.getText().toString();
        if(billData.isEmpty()){
            billET.setError(getString(R.string.error));
            return;
        }
        double bill = Double.parseDouble(billData);
        /* check the text from id.
        RadioButton rb = (RadioButton) findViewById(checkedID);
        System.out.println(rb.getText().toString());
        */
        switch (checkedID){
            case R.id.first_radio_button:
                calculate(bill, 10);
                break;

            case R.id.second_radio_button:
                calculate(bill, 20);
                break;

            default:
                String percentData = percentET.getText().toString();
                if(percentData.isEmpty()){
                    percentET.setError("Please fill this field...");
                    return;
                }
                int percent = Integer.parseInt(percentData);
                if(percent > 100){
                    percentET.setError("Max is 100%");
                    return;
                }
                calculate(bill, percent);
        }
    }

    private void calculate(double bill, int percent){
        double tip = bill * percent / 100;
        resultTV.setText("Tip: " + tip);
    }

}
