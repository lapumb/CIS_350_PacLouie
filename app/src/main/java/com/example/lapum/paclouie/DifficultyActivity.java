package com.example.lapum.paclouie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Difficulty activity handles three button clicks for the three game
 * difficulty. When a user selects a difficulty it will set the difficulty
 * and load the game.
 */
public class DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_page);
        final FloatingActionButton save = (FloatingActionButton)
                findViewById(R.id.saveDifficulty);

        //save difficulty, close out of settings
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                finish();
            }
        });
        
        final Button btnUnder = findViewById(R.id.btnUnder);
        btnUnder.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 1 and open game activity
                SettingsActivity.currentNumProfs = 1;
                SettingsActivity.currentNumSpeed = 1;
                SettingsActivity.currentNumRange = 1;
                SettingsActivity.currentNumLives = 5;
                //startActivity(new Intent(DifficultyActivity.this,
                //        GameActivity.class));
            }
        });

        final Button btnUpper = findViewById(R.id.btnUpper);
        btnUpper.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 5 and open game activity
                SettingsActivity.currentNumProfs = 5;
                SettingsActivity.currentNumSpeed = 5;
                SettingsActivity.currentNumRange = 5;
                SettingsActivity.currentNumLives = 3;
                //startActivity(new Intent(DifficultyActivity.this,
                //        GameActivity.class));
            }
        });

        final Button btnGrad = findViewById(R.id.btnGrad);
        btnGrad.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 9 and open game activity
                SettingsActivity.currentNumProfs = 9;
                SettingsActivity.currentNumSpeed = 9;
                SettingsActivity.currentNumRange = 9;
                SettingsActivity.currentNumLives = 1;
                //startActivity(new Intent(DifficultyActivity.this,
                //        GameActivity.class));
            }
        });
    }

}
