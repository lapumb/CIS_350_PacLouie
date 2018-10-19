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
 * number of profs can be modified. (Add to this whatever
 * settings get added (i.e speed, range, etc. ))
 */
public class SettingsActivity extends AppCompatActivity {

    /** Integer value for the number of profs in the game. **/
    public static int currentNumProfs = 1;

    /** Integer value for the speed in the game. **/
    public static int currentNumSpeed = 1;

    /** Integer value for the range in the game. **/
    public static int currentNumRange = 1;

    /** Integer value for the number of lives in the game. **/
    public static int currentNumLives = 1;

    /** String value for the number of profs to display. **/
    private String modifyNumProfs;

    /** String value for the speed to display. **/
    private String modifyNumSpeed;

    /** String value for the range to display. **/
    private String modifyNumRange;

    /** String value for the number of lives to display. **/
    private String modifyNumLives;

    /** Integer value for the maximum number of profs. **/
    private int maxNumProfs = 9;

    /** Integer that represents the minimum number of profs in a game. **/
    private int minNumProfs = 1;

    /** Integer value for the maximum speed profs can move. **/
    private int maxNumSpeed = 9;

    /** Integer that represents the minimum speed profs can move. **/
    private int minNumSpeed = 1;

    /** Integer value for the maximum range profs can move. **/
    private int maxNumRange= 9;

    /** Integer that represents the minimum range profs can move. **/
    private int minNumRange = 1;

    /** Integer value for the maximum number of lives in game. **/
    private int maxNumLives = 9;

    /** Integer that represents the minimum number of lives in game. **/
    private int minNumLives = 1;

    /** String to represent the number of profs. **/
    private String strNumProfs;

    /** String to represent the amount of speed. **/
    private String strNumSpeed;

    /** String to represent the range. **/
    private String strNumRange;

    /** String to represent the number of lives. **/
    private String strNumLives;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        //initializing currentNumProfs prof settings
        final Button minusProfs = (Button) findViewById(R.id.minusProfs);
        final Button addProfs = (Button) findViewById(R.id.addProfs);
        final TextView currentNumProfs = (TextView) findViewById(R.id.numProfs);

        //initializing currentNumProfs speed settings
        final Button minusSpeed = (Button) findViewById(R.id.minusSpeed);
        final Button addSpeed = (Button) findViewById(R.id.addSpeed);
        final TextView currentNumSpeed = (TextView) findViewById(R.id.numSpeed);

        //initializing currentNumProfs range settings
        final Button minusRange = (Button) findViewById(R.id.minusRange);
        final Button addRange = (Button) findViewById(R.id.addRange);
        final TextView currentNumRange = (TextView) findViewById(R.id.numRange);

        //initializing currentNumProfs lives settings
        final Button minusLives = (Button) findViewById(R.id.minusLives);
        final Button addLives = (Button) findViewById(R.id.addLives);
        final TextView currentNumLives = (TextView) findViewById(R.id.numLives);

        //settings the content and initializing the save fab
        final View parentLayout = (View) findViewById(android.R.id.content);
        final FloatingActionButton save = (FloatingActionButton)
                findViewById(R.id.saveSettings);

        //save settings, close out of settings
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });

        //setting initial text to be # of profs to 1;
        modifyNumProfs = currentNumProfs.getText().toString();
        modifyNumProfs = modifyNumProfs.substring(0, modifyNumProfs.length() - 2);
        modifyNumProfs = modifyNumProfs + ": " + SettingsActivity.currentNumProfs;
        currentNumProfs.setText(modifyNumProfs);

        //setting initial text to be # of speed to 1;
        modifyNumSpeed = currentNumSpeed.getText().toString();
        modifyNumSpeed = modifyNumSpeed.substring(0, modifyNumSpeed.length() - 2);
        modifyNumSpeed = modifyNumSpeed + ": " + SettingsActivity.currentNumSpeed;
        currentNumSpeed.setText(modifyNumSpeed);

        //setting initial text to be # of range to 1;
        modifyNumRange = currentNumRange.getText().toString();
        modifyNumRange = modifyNumRange.substring(0, modifyNumRange.length() - 2);
        modifyNumRange = modifyNumRange + ": " + SettingsActivity.currentNumRange;
        currentNumRange.setText(modifyNumRange);

        //setting initial text bo be # of lives to 1;
        modifyNumLives = currentNumLives.getText().toString();
        modifyNumLives = modifyNumLives.substring(0, modifyNumLives.length() - 2);
        modifyNumLives = modifyNumLives + ": " + SettingsActivity.currentNumLives;
        currentNumLives.setText(modifyNumLives);


        //subtract currentNumProfs of profs
        minusProfs.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //check to see if we can subtract a prof
                // or if we're at our min prof number
                if (SettingsActivity.currentNumProfs == minNumProfs) {
                    Snackbar.make(parentLayout, "Minimum number of profs is: "
                                    + minNumProfs, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, subtract 1 from currentNumProfs of profs
                    strNumProfs = Integer.toString(SettingsActivity.currentNumProfs);
                    SettingsActivity.currentNumProfs--;
                    modifyNumProfs = currentNumProfs.getText().toString();
                    modifyNumProfs = modifyNumProfs.substring(0, modifyNumProfs.length()
                            - (strNumProfs.length()));
                    modifyNumProfs = modifyNumProfs + SettingsActivity.currentNumProfs;
                    currentNumProfs.setText(modifyNumProfs);
                }
            }
        });

        //add to currentNumProfs of profs
        addProfs.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //checking to see if we can add more profs,
                // or if it would exceeds limit
                if (SettingsActivity.currentNumProfs == maxNumProfs) {
                    Snackbar.make(parentLayout, "Max number of profs is: "
                                    + maxNumProfs, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, add 1 to the currentNumProfs of profs
                    SettingsActivity.currentNumProfs++;
                    strNumProfs = Integer.toString(SettingsActivity.currentNumProfs);
                    modifyNumProfs = currentNumProfs.getText().toString();
                    modifyNumProfs = modifyNumProfs.substring(0, modifyNumProfs.length()
                            - (strNumProfs.length()));
                    modifyNumProfs = modifyNumProfs + SettingsActivity.currentNumProfs;
                    currentNumProfs.setText(modifyNumProfs);
                }
            }
        });


        //subtract currentNumSpeed of profs
        minusSpeed.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //check to see if we can subtract speed
                // or if we're at our min speed
                if (SettingsActivity.currentNumSpeed == minNumSpeed) {
                    Snackbar.make(parentLayout, "Minimum speed is: "
                                    + minNumSpeed, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, subtract 1 from currentNumSpeed
                    strNumSpeed = Integer.toString(SettingsActivity.currentNumSpeed);
                    SettingsActivity.currentNumSpeed--;
                    modifyNumSpeed = currentNumSpeed.getText().toString();
                    modifyNumSpeed = modifyNumSpeed.substring(0, modifyNumSpeed.length()
                            - (strNumSpeed.length()));
                    modifyNumSpeed = modifyNumSpeed + SettingsActivity.currentNumSpeed;
                    currentNumSpeed.setText(modifyNumSpeed);
                }
            }
        });

        //add to currentNumSpeed of profs
        addSpeed.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //checking to see if we can add speed,
                // or if it would exceeds limit
                if (SettingsActivity.currentNumSpeed == maxNumSpeed) {
                    Snackbar.make(parentLayout, "Max speed is: "
                                    + maxNumSpeed, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, add 1 to the currentNumSpeed of profs
                    SettingsActivity.currentNumSpeed++;
                    strNumSpeed = Integer.toString(SettingsActivity.currentNumSpeed);
                    modifyNumSpeed = currentNumSpeed.getText().toString();
                    modifyNumSpeed = modifyNumSpeed.substring(0, modifyNumSpeed.length()
                            - (strNumSpeed.length()));
                    modifyNumSpeed = modifyNumSpeed + SettingsActivity.currentNumSpeed;
                    currentNumSpeed.setText(modifyNumSpeed);
                }
            }
        });


        //subtract currentNumRange of profs
        minusRange.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //check to see if we can subtract range
                // or if we're at our min range
                if (SettingsActivity.currentNumRange == minNumRange) {
                    Snackbar.make(parentLayout, "Minimum range is: "
                                    + minNumRange, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, subtract 1 from currentNumRange of profs
                    strNumRange = Integer.toString(SettingsActivity.currentNumRange);
                    SettingsActivity.currentNumRange--;
                    modifyNumRange = currentNumRange.getText().toString();
                    modifyNumRange = modifyNumRange.substring(0, modifyNumRange.length()
                            - (strNumRange.length()));
                    modifyNumRange = modifyNumRange + SettingsActivity.currentNumRange;
                    currentNumRange.setText(modifyNumRange);
                }
            }
        });

        //add to currentNumRange of profs
        addRange.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //checking to see if we can add range,
                // or if it would exceeds limit
                if (SettingsActivity.currentNumRange == maxNumRange) {
                    Snackbar.make(parentLayout, "Max range is: "
                                    + maxNumRange, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, add 1 to the currentNumRange of profs
                    SettingsActivity.currentNumRange++;
                    strNumRange = Integer.toString(SettingsActivity.currentNumRange);
                    modifyNumRange = currentNumRange.getText().toString();
                    modifyNumRange = modifyNumRange.substring(0, modifyNumRange.length()
                            - (strNumRange.length()));
                    modifyNumRange = modifyNumRange + SettingsActivity.currentNumRange;
                    currentNumRange.setText(modifyNumRange);
                }
            }
        });

        //subtract currentNumLives in game
        minusLives.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //check to see if we can subtract a life
                // or if we're at our min lives
                if (SettingsActivity.currentNumLives == minNumLives) {
                    Snackbar.make(parentLayout, "Minimum number of lives is: "
                                    + minNumLives, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, subtract 1 from currentNumLives in game
                    strNumLives = Integer.toString(SettingsActivity.currentNumLives);
                    SettingsActivity.currentNumLives--;
                    modifyNumLives = currentNumLives.getText().toString();
                    modifyNumLives = modifyNumLives.substring(0, modifyNumLives.length()
                            - (strNumLives.length()));
                    modifyNumLives = modifyNumLives + SettingsActivity.currentNumLives;
                    currentNumLives.setText(modifyNumLives);
                }
            }
        });

        //add to currentNumLives in game
        addLives.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                //checking to see if we can add lives,
                // or if it would exceeds limit
                if (SettingsActivity.currentNumLives == maxNumLives) {
                    Snackbar.make(parentLayout, "Max number of lives is: "
                                    + maxNumLives, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                } else {
                    //if not, add 1 to the number of lives in game
                    SettingsActivity.currentNumLives++;
                    strNumLives = Integer.toString(SettingsActivity.currentNumLives);
                    modifyNumLives = currentNumLives.getText().toString();
                    modifyNumLives = modifyNumLives.substring(0, modifyNumLives.length()
                            - (strNumLives.length()));
                    modifyNumLives = modifyNumLives + SettingsActivity.currentNumLives;
                    currentNumLives.setText(modifyNumLives);
                }
            }
        });
    }
}
