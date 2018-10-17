package com.example.lapum.paclouie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Activity to display the PacLouie's highscores.
 */
public class HighscoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        //initializing TextView's to manipulate
        TextView highscore1 = (TextView) findViewById(R.id.highscore1);
        TextView highscore2 = (TextView) findViewById(R.id.highscore2);
        TextView highscore3 = (TextView) findViewById(R.id.highscore3);
        TextView highscore4 = (TextView) findViewById(R.id.highscore4);
        TextView highscore5 = (TextView) findViewById(R.id.highscore5);
        TextView highscore6 = (TextView) findViewById(R.id.highscore6);
        TextView highscore7 = (TextView) findViewById(R.id.highscore7);
        TextView highscore8 = (TextView) findViewById(R.id.highscore8);
        TextView highscore9 = (TextView) findViewById(R.id.highscore9);
        TextView highscore10 = (TextView) findViewById(R.id.highscore10);

    }

}
