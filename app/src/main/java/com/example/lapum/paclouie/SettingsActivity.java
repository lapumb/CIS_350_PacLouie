package com.example.lapum.paclouie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Class to display the settings page where the
 * number of profs can be modified.
 */
public class SettingsActivity extends AppCompatActivity {

    /** Integer value for the number of profs in the game. **/
    public static int num = 1;
    /** String value for the number of profs to display. **/
    private String modifyNum;
    /** Integer value for the maximum number of profs. **/
    private int maxNumProfs = 9;
    /** Integer that represents the minimum number of profs in a game. **/
    private int minNumProfs = 1;
    /** String to represent the number of profs. **/
    private String strNum;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        final Button minus = (Button) findViewById(R.id.minusButton);
        final Button plus = (Button) findViewById(R.id.addButton);
        final TextView currentNum = (TextView) findViewById(R.id.numProfs);
        final View parentLayout = (View) findViewById(android.R.id.content);
        final FloatingActionButton save = (FloatingActionButton)
                findViewById(R.id.saveSettings);

        //save settings
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                /*Intent intent = new Intent();
                intent.putExtra("numProfs", num);
                setResult(GameActivity.SETTINGS_RESULT, intent); */
                finish();
            }
        });


        //setting initial text to be # of profs to 1;
        modifyNum = currentNum.getText().toString();
        modifyNum = modifyNum.substring(0, modifyNum.length() - 2);
        modifyNum = modifyNum + ": " + num;
        currentNum.setText(modifyNum);

        //subtract num of profs
        minus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //check to see if we can subtract a prof
                // or if we're at our min prof number
                if (num == minNumProfs) {
                    Snackbar.make(parentLayout, "Minimum number of profs is: "
                                    + minNumProfs, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, subtract 1 from num of profs
                    strNum = Integer.toString(num);
                    num--;
                    modifyNum = currentNum.getText().toString();
                    modifyNum = modifyNum.substring(0, modifyNum.length()
                            - (strNum.length()));
                    modifyNum = modifyNum + num;
                    currentNum.setText(modifyNum);
                }
            }
        });

        //add to num of profs
        plus.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //checking to see if we can add more profs,
                // or if it would exceeds limit
                if (num == maxNumProfs) {
                    Snackbar.make(parentLayout, "Max number of profs is: "
                                    + maxNumProfs, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, add 1 to the num of profs
                    num++;
                    strNum = Integer.toString(num);
                    modifyNum = currentNum.getText().toString();
                    modifyNum = modifyNum.substring(0, modifyNum.length()
                            - (strNum.length()));
                    modifyNum = modifyNum + num;
                    currentNum.setText(modifyNum);
                }
            }
        });
    }
}
