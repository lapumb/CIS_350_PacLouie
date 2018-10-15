package com.example.lapum.paclouie;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    private int num = 1;
    private String modifyNum;
    int maxNumProfs = 9;
    int minNumProfs = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Button minus = (Button) findViewById(R.id.minusButton);
        Button plus = (Button) findViewById(R.id.addButton);
        final TextView currentNum = (TextView) findViewById(R.id.numProfs);
        final View parentLayout = (View) findViewById(android.R.id.content);

        //setting initial text to be # of profs to 1;
        modifyNum = currentNum.getText().toString();
        modifyNum = modifyNum.substring(0, modifyNum.length()-2);
        modifyNum = modifyNum + ": " + num;
        currentNum.setText(modifyNum);

        minus.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                //subtract 1 from current num of profs
                //figure out how to set bounds (0 < # <= n)
                //(whatever we want max num of profs to be, replace 9)
                if(num == minNumProfs) {
                    Snackbar.make(parentLayout, "Minimum number of profs is: " + minNumProfs,
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else {
                    num--;
                    modifyNum = currentNum.getText().toString();
                    modifyNum = modifyNum.substring(0, modifyNum.length() - 1);
                    modifyNum = modifyNum + num;
                    currentNum.setText(modifyNum);
                }
            }
        });

        plus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //add 1 to current num of profs
                if(num == maxNumProfs) {
                    Snackbar.make(parentLayout, "Max number of profs is: " + maxNumProfs,
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                else {
                    num++;
                    modifyNum = currentNum.getText().toString();
                    modifyNum = modifyNum.substring(0, modifyNum.length() - 1);
                    modifyNum = modifyNum + num;
                    currentNum.setText(modifyNum);
                }
            }
        });
    }
}
