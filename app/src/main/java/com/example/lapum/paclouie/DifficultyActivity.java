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
                SettingsActivity.setCurrentNumProfs(1);
                SettingsActivity.setCurrentNumSpeed(1);
                SettingsActivity.setCurrentNumRange(1);
                SettingsActivity.setCurrentNumLives(5);
                //startActivity(new Intent(DifficultyActivity.this,
                //        GameActivity.class));
            }
        });

        final Button btnUpper = findViewById(R.id.btnUpper);
        btnUpper.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 5 and open game activity
                SettingsActivity.setCurrentNumProfs(5);
                SettingsActivity.setCurrentNumSpeed(5);
                SettingsActivity.setCurrentNumRange(5);
                SettingsActivity.setCurrentNumLives(3);
                //startActivity(new Intent(DifficultyActivity.this,
                //        GameActivity.class));
            }
        });

        final Button btnGrad = findViewById(R.id.btnGrad);
        btnGrad.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 9 and open game activity
                SettingsActivity.setCurrentNumProfs(9);
                SettingsActivity.setCurrentNumSpeed(9);
                SettingsActivity.setCurrentNumRange(9);
                SettingsActivity.setCurrentNumLives(1);
                //startActivity(new Intent(DifficultyActivity.this,
                //        GameActivity.class));
            }
        });
    }

}
