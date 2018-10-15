package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class DifficultyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_page);

        final Button btnUnder = findViewById(R.id.btnUnder);
        btnUnder.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //set number of profs to 1 and open game activity
                SettingsActivity.num = 1;
                startActivity(new Intent(DifficultyActivity.this, GameActivity.class));

            }
        });

        final Button btnUpper = findViewById(R.id.btnUpper);
        btnUpper.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //set number of profs to 5 and open game activity
                SettingsActivity.num = 5;
                startActivity(new Intent(DifficultyActivity.this, GameActivity.class));
            }
        });

        final Button btnGrad = findViewById(R.id.btnGrad);
        btnGrad.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //set number of profs to 9 and open game activity
                SettingsActivity.num = 9;
                startActivity(new Intent(DifficultyActivity.this, GameActivity.class));
            }
        });


    }

}
