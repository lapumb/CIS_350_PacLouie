package com.example.lapum.paclouie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.TextView;

/**
 * Activity to display the PacLouie's highscores.
 */
public class HighscoreActivity extends AppCompatActivity {

    /** Complete list of highscores. **/
    private TextView[] scoreTexts;

    /** Highscore textviews. **/
    private TextView highscore1, highscore2, highscore3, highscore4, highscore5,
            highscore6, highscore7, highscore8, highscore9, highscore10;

    /** Last score textview. **/
    private TextView lastScore;

    /** Most recent game score. **/
    private int lastGameScore;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        String mostRecentScore;
        this.lastScore = (TextView) findViewById(R.id.lastScore);

        //string for manipulating textview texts
        String scoreText;

        //instantiating TextViews
        instantiateScoresText();

        //recieving score from gameactivity
        Intent mIntent = getIntent();

        //if we go strait from GameActivity to HighscoreActivity
        if (mIntent.getIntExtra("SCORE", 0) >= GameActivity.getLastScore()) {
            lastGameScore = mIntent.getIntExtra("SCORE", 0);
        } else {
            lastGameScore = GameActivity.getLastScore();
        }

        //setting last score text
        int displayLatestScore = GameActivity.getLastScore();
        mostRecentScore = getString(R.string.lastScore);
        mostRecentScore = mostRecentScore + " " + displayLatestScore;
        lastScore.setText(mostRecentScore);

        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // In landscape
            scoreTexts = textListLandscape();
        } else {
            // In portrait
            scoreTexts = textListPortrait();
        }


        //initializing SharedPreference ints
        final SharedPreferences settings = getSharedPreferences("GAME_DATA",
                Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = settings.edit();
        int tempHighscore1 = settings.getInt("HIGH_SCORE1", 0);
        int tempHighscore2 = settings.getInt("HIGH_SCORE2", 0);
        int tempHighscore3 = settings.getInt("HIGH_SCORE3", 0);
        int tempHighscore4 = settings.getInt("HIGH_SCORE4", 0);
        int tempHighscore5 = settings.getInt("HIGH_SCORE5", 0);
        int tempHighscore6 = settings.getInt("HIGH_SCORE6", 0);
        int tempHighscore7 = settings.getInt("HIGH_SCORE7", 0);
        int tempHighscore8 = settings.getInt("HIGH_SCORE8", 0);
        int tempHighscore9 = settings.getInt("HIGH_SCORE9", 0);
        int tempHighscore10 = settings.getInt("HIGH_SCORE10", 0);


        //adding all current high scores to a list
        int[] list = {tempHighscore1, tempHighscore2, tempHighscore3,
                tempHighscore4, tempHighscore5, tempHighscore6, tempHighscore7,
                tempHighscore8, tempHighscore9, tempHighscore10};


        // Clear preferences
        TextView resetHighscores = (TextView) findViewById(R.id.resetScores);
        resetHighscores.setOnClickListener(new TextView.OnClickListener() {
            @Override
            public void onClick(final View v) {
                SharedPreferences.Editor preferencesEditor = settings.edit();
                preferencesEditor.clear();
                preferencesEditor.apply();

                //reloading highscore activity
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        //checking latest score is greater than a highscore in list
        for (int score = 0; score < list.length; score++) {
            if (lastGameScore > list[score]) {
                int i = 9;
                while (i != score) {
                    //shift all other score down one,
                    // printing / replacing the score
                    list[i] = list[i - 1];

                    //saving other scores down one index down
                    editor.putInt("HIGH_SCORE" + Integer
                            .toString(i + 1), list[i]);
                    editor.commit();
                    i--;
                }
                //adding new high score to list in place of old score
                list[score] = lastGameScore;

                //saving
                editor.putInt("HIGH_SCORE" + Integer .toString(score + 1),
                        list[score]);
                editor.commit();

                //making sure highscore is not recorded multiple times
                lastGameScore = 0;

                //breaking out of for loop
                score = 9;
            }
            if (lastGameScore == list[score]) {
                score = 9;
            }
        }

        //setting text of each highscore textview in view
        for (int i = 0; i < scoreTexts.length; i++) {
            scoreText = Integer .toString(i + 1) + ". " + list[i];
            scoreTexts[i].setText(scoreText);
        }


    }

    /**
     * Adding highscore textviews to temp list for portrait view
     * (10 highscore texts).
     * @return List of highscores.
     */
    private TextView[] textListPortrait() {
        TextView[] tempScoreTexts = {highscore1, highscore2, highscore3,
                highscore4, highscore5, highscore6, highscore7, highscore8,
                highscore9, highscore10};
        return tempScoreTexts;
    }

    /**
     * Adding highscore textviews to temp list for landscape view
     * (5 high scores).
     * @return List of highscores in landscape mode.
     */
    private TextView[] textListLandscape() {
        TextView[] tempScoreTexts = {highscore1, highscore2, highscore3,
                highscore4, highscore5};
        return tempScoreTexts;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HighscoreActivity.this, MainActivity.class);
        startActivity(intent);
    }


    /**
     * Instantiate high scores texts.
     */
    public void instantiateScoresText() {
        //initializing
        this.highscore1 = (TextView) findViewById(R.id.highscore1);
        this.highscore2 = (TextView) findViewById(R.id.highscore2);
        this.highscore3 = (TextView) findViewById(R.id.highscore3);
        this.highscore4 = (TextView) findViewById(R.id.highscore4);
        this.highscore5 = (TextView) findViewById(R.id.highscore5);
        this.highscore6 = (TextView) findViewById(R.id.highscore6);
        this.highscore7 = (TextView) findViewById(R.id.highscore7);
        this.highscore8 = (TextView) findViewById(R.id.highscore8);
        this.highscore9 = (TextView) findViewById(R.id.highscore9);
        this.highscore10 = (TextView) findViewById(R.id.highscore10);
    }
}
