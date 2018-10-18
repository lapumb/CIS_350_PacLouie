package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
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

        final Button btnUnder = findViewById(R.id.btnUnder);
        btnUnder.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 1 and open game activity
                SettingsActivity.num = 1;
                startActivity(new Intent(DifficultyActivity.this,
                        GameActivity.class));
            }
        });

        final Button btnUpper = findViewById(R.id.btnUpper);
        btnUpper.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 5 and open game activity
                SettingsActivity.num = 5;
                startActivity(new Intent(DifficultyActivity.this,
                        GameActivity.class));
            }
        });

        final Button btnGrad = findViewById(R.id.btnGrad);
        btnGrad.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                //set number of profs to 9 and open game activity
                SettingsActivity.num = 9;
                startActivity(new Intent(DifficultyActivity.this,
                        GameActivity.class));
            }
        });
    }

}
