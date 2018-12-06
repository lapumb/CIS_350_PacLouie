package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Activity to display the PacLouie's highscores.
 */
public class HighscoreActivity extends AppCompatActivity {

    //string for each highscore
    private String scoreText;

    //complete list of highscores
    ArrayList<Integer> highscoreList = new ArrayList<>();
    ArrayList<TextView>highscoreTextList = new ArrayList<>();

    TextView highscore1, highscore2, highscore3, highscore4, highscore5, highscore6, highscore7,
            highscore8, highscore9, highscore10;

    //scores to go in order least to highest
    int score0;
    int score1;
    int score2;
    int score3;
    int score4;
    int score5;
    int score6;
    int score7;
    int score8;
    int score9;

    public int getScore0() {
        return score0;
    }

    public void setScore0(int score0) {
        this.score0 = score0;
    }

    public int getScore1() {
        return score1;
    }

    public void setScore1(int score1) {
        this.score1 = score1;
    }

    public int getScore2() {
        return score2;
    }

    public void setScore2(int score2) {
        this.score2 = score2;
    }

    public int getScore3() {
        return score3;
    }

    public void setScore3(int score3) {
        this.score3 = score3;
    }

    public int getScore4() {
        return score4;
    }

    public void setScore4(int score4) {
        this.score4 = score4;
    }

    public int getScore5() {
        return score5;
    }

    public void setScore5(int score5) {
        this.score5 = score5;
    }

    public int getScore6() {
        return score6;
    }

    public void setScore6(int score6) {
        this.score6 = score6;
    }

    public int getScore7() {
        return score7;
    }

    public void setScore7(int score7) {
        this.score7 = score7;
    }

    public int getScore8() {
        return score8;
    }

    public void setScore8(int score8) {
        this.score8 = score8;
    }

    public int getScore9() {
        return score9;
    }

    public void setScore9(int score9) {
        this.score9 = score9;
    }


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        //instantiating TextViews
        instantiateScoresText();

        //sending texts & scores to lists
        addScoresToList();
        addTextViewsToList();

        //setting initial text of textviews
        for(TextView score : highscoreTextList) {
            scoreText = score.getText().toString();
            scoreText = scoreText + " " + 0;
            score.setText(scoreText);
        }

    }

    /**
     * Adds the highscores to lists.
     */
    private void addScoresToList() {
        Integer[] tempHighScores = {score0, score1, score2, score3, score4,
                score5, score6, score7, score8, score9};
        Collections.addAll(highscoreList, tempHighScores);
    }

    //adding highscore text views to lists
    private void addTextViewsToList() {
        TextView[] tempScoreTexts = {highscore1, highscore2, highscore3, highscore4, highscore5,
                highscore6, highscore7, highscore8, highscore9, highscore10};
        Collections.addAll(highscoreTextList, tempScoreTexts);
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
