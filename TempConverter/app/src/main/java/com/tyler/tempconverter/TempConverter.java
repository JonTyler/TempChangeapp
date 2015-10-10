/*TempConverter.java
 *Assignment 1
 *
 * Revision History
 *      Jonathon Tyler, 2015.10.01: Created
 *      Jonathon Tyler, 2015.10.05: Completed

 */
package com.tyler.tempconverter;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.TextView.OnEditorActionListener;
import android.content.SharedPreferences.Editor;

import java.text.DecimalFormat;

public class TempConverter extends AppCompatActivity implements OnEditorActionListener {
    //declare variables
    private EditText inputEditText;
    private TextView resultLabel;
    private String fahrenheitValueString;
    private float celsius;
    private SharedPreferences savedValues;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);
        //assign variables to widgets
        inputEditText = (EditText) findViewById(R.id.inputEditText);
        resultLabel = (TextView) findViewById(R.id.resultLabel);
        //set listener
        inputEditText.setOnEditorActionListener(this);
    }


    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_ACTION_UNSPECIFIED)
            calculateCelsius();
        return false;
    }

    public void calculateCelsius () {
        /* get the fahrenheit value */
        fahrenheitValueString = inputEditText.getText().toString();
        float fahrenheitValue;
        if(fahrenheitValueString.equals(""))
        {
            fahrenheitValue = 0f;
        }
        else
            fahrenheitValue = Float.parseFloat(fahrenheitValueString);

        float conversionRatio = (5f/9f);
        celsius = (fahrenheitValue - 32f)*conversionRatio;
        //imported format class used here
        DecimalFormat df = new DecimalFormat("###.##");
        String celsiusString = df.format(celsius);
        resultLabel.setText(celsiusString);
    }


}
