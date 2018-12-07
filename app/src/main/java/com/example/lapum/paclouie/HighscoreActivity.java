package com.example.lapum.paclouie;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Activity to display the PacLouie's highscores.
 */
public class HighscoreActivity extends AppCompatActivity {

    //complete list of highscores
    TextView scoreTexts[];

    //highscore textviews
    TextView highscore1, highscore2, highscore3, highscore4, highscore5, highscore6, highscore7,
            highscore8, highscore9, highscore10;

    //last score textview
    TextView lastScore;

    public int lastGameScore;

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

        //TODO sending textviews to a list
        //addTextViewsToList();

        //recieving score from gameactivity
        Intent mIntent = getIntent();

        //if we go strait from GameActivity to HighscoreActivity
        if(mIntent.getIntExtra("SCORE", 0) >= GameActivity.lastScore) {
            lastGameScore = mIntent.getIntExtra("SCORE", 0);
        }
        //if we do not
        else {
            lastGameScore = GameActivity.lastScore;
        }

        //setting last score text
        int displayLatestScore = GameActivity.lastScore;
        mostRecentScore = getString(R.string.lastScore);
        mostRecentScore = mostRecentScore +" " + displayLatestScore;
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
        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highscore1 = settings.getInt("HIGH_SCORE1", 0);
        int highscore2 = settings.getInt("HIGH_SCORE2", 0);
        int highscore3 = settings.getInt("HIGH_SCORE3", 0);
        int highscore4 = settings.getInt("HIGH_SCORE4", 0);
        int highscore5 = settings.getInt("HIGH_SCORE5", 0);
        int highscore6 = settings.getInt("HIGH_SCORE6", 0);
        int highscore7 = settings.getInt("HIGH_SCORE7", 0);
        int highscore8 = settings.getInt("HIGH_SCORE8", 0);
        int highscore9 = settings.getInt("HIGH_SCORE9", 0);
        int highscore10 = settings.getInt("HIGH_SCORE10", 0);


        //adding all current high scores to a list
        int list[] = {highscore1, highscore2, highscore3, highscore4, highscore5,
                highscore6, highscore7, highscore8, highscore9, highscore10};

        SharedPreferences.Editor editor = settings.edit();


        //checking if most recent score is larger than any currently in highscores
        /*for (int score = 0; score < list.length; score++) {
            if (lastGameScore >= list[score]) {
                int i = 9;
                while(i != score) {
                    //shift all other score down one, printing / replacing the score
                    list[i] = list[i-1];
                    scoreText = Integer .toString(i+1) + ". " + list[i];
                    scoreTexts[i].setText(scoreText);

                    //saving other scores down one index down
                    editor.putInt("HIGH_SCORE" + Integer .toString(i+1), list[i]);
                    editor.commit();
                    i--;
                }
                //adding new high score to list in place of old score
                list[score] = lastGameScore;
                //setting specific highscore to be new score
                scoreText = Integer .toString(score+1) + ". " + list[score];
                scoreTexts[score].setText(scoreText);

                //saving
                editor.putInt("HIGH_SCORE" + Integer .toString(score+1), list[score]);
                editor.commit();
                break;
            }
            else {
                //otherwise, keep it set to what it was
                scoreText = Integer .toString(score+1) + ". " + list[score];
                scoreTexts[score].setText(scoreText);
            }
        } */
        //checking latest score is greater than a highscore in list
        for (int score = 0; score < list.length; score++) {
            if (lastGameScore >= list[score]) {
                int i = 9;
                while(i != score) {
                    //shift all other score down one, printing / replacing the score
                    list[i] = list[i-1];

                    //saving other scores down one index down
                    editor.putInt("HIGH_SCORE" + Integer .toString(i+1), list[i]);
                    editor.commit();
                    i--;
                }
                //adding new high score to list in place of old score
                list[score] = lastGameScore;

                //saving
                editor.putInt("HIGH_SCORE" + Integer .toString(score+1), list[score]);
                editor.commit();
                break;
            }
        }

        //setting text of each highscore textview in view
        for(int i = 0; i < scoreTexts.length; i++) {
            scoreText = Integer .toString(i+1) + ". " + list[i];
            scoreTexts[i].setText(scoreText);
        }

    }

    //adding highscore textviews to temp list for portrait view (10 highscore texts)
    private TextView[] textListPortrait() {
        TextView tempScoreTexts[] = {highscore1, highscore2, highscore3, highscore4, highscore5,
                highscore6, highscore7, highscore8, highscore9, highscore10};
        return tempScoreTexts;
    }

    //adding highscore textviews to temp list for landscape view (5 high scores)
    private TextView[] textListLandscape() {
        TextView tempScoreTexts[] = {highscore1, highscore2, highscore3, highscore4, highscore5};
        return tempScoreTexts;
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(HighscoreActivity.this, MainActivity.class);
        startActivity(intent);
    }


    //instantiate high scores texts
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
