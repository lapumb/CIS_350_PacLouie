package com.example.lapum.paclouie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity {

    public static int num = 1;
    private String modifyNum;
    int maxNumProfs = 9;
    int minNumProfs = 1;
    private String strNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Button minus = (Button) findViewById(R.id.minusButton);
        final Button plus = (Button) findViewById(R.id.addButton);
        final TextView currentNum = (TextView) findViewById(R.id.numProfs);
        final View parentLayout = (View) findViewById(android.R.id.content);
        final FloatingActionButton save = (FloatingActionButton) findViewById(R.id.saveSettings);

        //save settings
        save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent();
                intent.putExtra("numProfs", num);
                setResult(GameActivity.SETTINGS_RESULT, intent); */
                finish();
            }
        });


        //setting initial text to be # of profs to 1;
        modifyNum = currentNum.getText().toString();
        modifyNum = modifyNum.substring(0, modifyNum.length()-2);
        modifyNum = modifyNum + ": " + num;
        currentNum.setText(modifyNum);

        //subtract num of profs
        minus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check to see if we can subtract a prof or if were at our min prof number
                if(num == minNumProfs) {
                    Snackbar.make(parentLayout, "Minimum number of profs is: " + minNumProfs,
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                //if not, subtract 1 from num of profs
                else {
                    strNum = Integer.toString(num);
                    num--;
                    modifyNum = currentNum.getText().toString();
                    modifyNum = modifyNum.substring(0, modifyNum.length() -
                            (strNum.length()));
                    modifyNum = modifyNum + num;
                    currentNum.setText(modifyNum);
                }
            }
        });

        //add to num of profs
        plus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //checking to see if we can add more profs, or if it would exceeds limit
                if(num == maxNumProfs) {
                    Snackbar.make(parentLayout, "Max number of profs is: " + maxNumProfs,
                            Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                //if not, add 1 to the num of profs
                else {
                    num++;
                    strNum = Integer.toString(num);
                    modifyNum = currentNum.getText().toString();
                    modifyNum = modifyNum.substring(0, modifyNum.length() - (strNum.length()));
                    modifyNum = modifyNum + num;
                    currentNum.setText(modifyNum);
                }
            }
        });
    }
}
