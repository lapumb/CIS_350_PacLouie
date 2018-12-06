package com.example.lapum.paclouie;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * The PacLouie game activity; view and logic to play the game.
 */
public class GameActivity extends AppCompatActivity {

    /** Game is Running boolean **/
    boolean gameIsRunning;

    /** X location. **/
    private int x;

    /** Y location. **/
    private int y;

    /** PacLouie layout. **/
    private RelativeLayout layout;

    /** string to show number of lives remaining **/
    private String decreaseNumLives;

    /** string to show current score of the game **/
    private String currentScore;

    /** Score obainted in game **/
    private int scoreBoard = 0;

    /** variable for the selected number of lives to START game **/
    final private int startLives = SettingsActivity.getCurrentNumLives();

    /** Variable for the number of profs in the game. **/
    private int numProfs = SettingsActivity.getCurrentNumProfs();

    /** Variable for speed of profs in game **/
    private int numSpeed = SettingsActivity.getCurrentNumSpeed();

    /** Variable for range of profs in game **/
    private int numRange = SettingsActivity.getCurrentNumRange();

    /** Variable for number of lives in game **/
    private int numLives = SettingsActivity.getCurrentNumLives();

    /** Variable for the number of visible A's. **/
    protected int numAVisible;

    /** Variable to set the actual speed of the profs movements **/
    private int speed = Professor.getRealSpeed(numSpeed);


   //Images for profs and louie
    ImageView prof0, prof1, prof2, prof3, prof4, prof5, prof6, prof7, prof8;
    ImageView louie;

    //objects Louie is to achieve
    ImageView a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14,
                a15, a16, a17, a18, a19, a20, a21, a22, a23, a24;

    //text views in upper corners
    TextView score, livesRemaining;
    ArrayList<ImageView> profList = new ArrayList<>();
    ArrayList<ImageView> aList = new ArrayList<>();
    ArrayList<ImageView> aVisibleList = new ArrayList<>();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        gameIsRunning = true;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = findViewById(R.id.gameView);

        //initializing images (profs, louie, a's)
        InstantiateProfs();
        this.louie = findViewById(R.id.gameLouie);
        InstantiateAs();

        //text in upper corners (always visible)
        this.score = (TextView) findViewById(R.id.scoreText);
        this.livesRemaining = (TextView) findViewById(R.id.livesText);

        AddImageViewsToList();

        //initially setting all profs to not appear (gone)
        for(ImageView prof : profList){
            prof.setVisibility(View.GONE);
        }

        //initially setting all a's to be gone
        for(ImageView a : aList){
            a.setVisibility(View.GONE);
        }

        setProfVisibility(numProfs); //setting how many profs are visible
        setAVisibility(numProfs, numRange, numSpeed, numLives); //setting number of A's appearing

        handleRunables();

        instantiateGameText();

        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(250, 250);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());
    }

    //instantiating textView score / lives remaining
    private void instantiateGameText() {
        //lives remaining text
        decreaseNumLives = livesRemaining.getText().toString();
        decreaseNumLives = decreaseNumLives + " " + numLives;
        livesRemaining.setText(decreaseNumLives);

        //beginning score text
        currentScore = score.getText().toString();
        currentScore = currentScore + " " + scoreBoard;
        score.setText(currentScore);
    }


    //handler for moving profs, prof collisions, collecting A's.
    private void handleRunables() {
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                callMoveProf();
                handler.postDelayed(this, speed);
            }
        };

        final Runnable r2 = new Runnable() {
            @Override
            public void run() {
                aObtained();
                handler.postDelayed(this, 1);
            }
        };

        final Runnable r3 = new Runnable() {
            @Override
            public void run() {
                profCollision();
                handler.postDelayed(this, 1);
            }
        };
        handler.postDelayed(r, 0);
        handler.postDelayed(r2, 0);
        handler.postDelayed(r3, 0);
    }

    /**
     * Instantiate prof ImageViews.
     */
    private void InstantiateProfs() {
        this.prof0 = findViewById(R.id.prof0);
        this.prof1 = findViewById(R.id.prof1);
        this.prof2 = findViewById(R.id.prof2);
        this.prof3 = findViewById(R.id.prof3);
        this.prof4 = findViewById(R.id.prof4);
        this.prof5 = findViewById(R.id.prof5);
        this.prof6 = findViewById(R.id.prof6);
        this.prof7 = findViewById(R.id.prof7);
        this.prof8 = findViewById(R.id.prof8);
    }

    /**
     * Instantiate A ImageViews.
     */
    private void InstantiateAs() {
        this.a0 = findViewById(R.id.a0);
        this.a1 = findViewById(R.id.a1);
        this.a2 = findViewById(R.id.a2);
        this.a3 = findViewById(R.id.a3);
        this.a4 = findViewById(R.id.a4);
        this.a5 = findViewById(R.id.a5);
        this.a6 = findViewById(R.id.a6);
        this.a7 = findViewById(R.id.a7);
        this.a8 = findViewById(R.id.a8);
        this.a9 = findViewById(R.id.a9);
        this.a10 = findViewById(R.id.a10);
        this.a11 = findViewById(R.id.a11);
        this.a12 = findViewById(R.id.a12);
        this.a13 = findViewById(R.id.a13);
        this.a14 = findViewById(R.id.a14);
        this.a15 = findViewById(R.id.a15);
        this.a16 = findViewById(R.id.a16);
        this.a17 = findViewById(R.id.a17);
        this.a18 = findViewById(R.id.a18);
        this.a19 = findViewById(R.id.a19);
        this.a20 = findViewById(R.id.a20);
        this.a21 = findViewById(R.id.a21);
        this.a22 = findViewById(R.id.a22);
        this.a23 = findViewById(R.id.a23);
        this.a24 = findViewById(R.id.a24);
    }

    /**
     * Adds the prof's and a's to lists.
     */
    private void AddImageViewsToList() {
        ImageView[] tempProfList = {prof0, prof1, prof2, prof3, prof4, prof5, prof6, prof7, prof8};
        Collections.addAll(profList, tempProfList);
        ImageView[] tempAList = {a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14,
                a15, a16, a17, a18, a19, a20, a21, a22, a23, a24};
        Collections.addAll(aList, tempAList);
    }


    //function to determine which profs are present and need movement
    public void callMoveProf() {
        for(ImageView prof : profList){
            if(prof.getVisibility() == View.VISIBLE)
                moveProf(prof, numRange);
        }
    }

    /*
    /**Moves the professor that is being called
    * @param ImageView prof the prof that wants to be moved
    * @param int range professors can move
     */
    public void moveProf(ImageView prof, int range) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //setting the range
        range = range * 3;

        //difference in x and y
        int dx;
        int dy;
        int rnd;
        float mult = (float).9;

        //random to choose direction of professor
        Random random = new Random();
        dx = random.nextInt(2);
        dy = random.nextInt(2);
        rnd = random.nextInt(10);

        //applying range to prof movement
        if(rnd >= 5) {
            for(int i = 0; i <= range; i++) {
                if((prof.getX() + dx * mult) < width)
                    prof.setX(prof.getX() + dx * mult);
                if((prof.getY() + dy * mult) < height)
                    prof.setY(prof.getY() + dy * mult);
            }
        }
        else {
            for(int i = 0; i <= range; i++) {
                if((prof.getX() - dx * mult) >= 0)
                    prof.setX(prof.getX() - dx * mult);
                if((prof.getY() - dy * mult) >= 0)
                    prof.setY(prof.getY() - dy * mult);
            }
        }
        //profCollision(louie, prof); //handles collisions with prof
    }

    //randomly generating which profs appear (user selected amount)
    public void setProfVisibility(int numProfs) {
        Random rnd = new Random();
        for (int i = 0; i < numProfs; i++) {
            int rand = rnd.nextInt(9);
            if (profList.get(rand).getVisibility() == View.GONE)
                profList.get(rand).setVisibility(View.VISIBLE);
            else
                i--;
        }
    }


    //returns which profs are visible.
    private ImageView[] getProfsVisible() {
        ImageView visible[] = new ImageView[10];
        for(int i = 0; i < profList.size(); i++){
            if (profList.get(i).getVisibility() == View.GONE)
                visible[i] = profList.get(i);
        }
        return visible;
    }

    //method to set which A's are visible (random)
    public void setAVisibility(int profs, int range, int speed, int lives) {
        Random rnd = new Random();
        int numA = 1 + ((profs/2) + 2) + ((range/2) + 2) + ((speed/2) + 2) + ((lives/2) + 2);
        numAVisible = numA;
        for(int i = 0; i <= numA; i++) {
            int rand = rnd.nextInt(25);
            if(aList.get(rand).getVisibility() == View.GONE) {
                aList.get(rand).setVisibility((View.VISIBLE));
                aVisibleList.add(aList.get(rand));
            }
            else
                i--;
        }
    }

    //returns which A's are visible
    private ImageView[] getAsVisible() {
        ImageView visible[] = new ImageView[25];
        for(int i = 0; i < aList.size(); i++){
            if (aList.get(i).getVisibility() == View.GONE)
                visible[i] = aList.get(i);
        }
        return visible;
    }


    //checking if ImageView's overlap (I think)
    private boolean isViewOverlapping(ImageView firstView, ImageView secondView) {
        int[] firstPosition = new int[2];
        int[] secondPosition = new int[2];

        firstView.getLocationOnScreen(firstPosition);
        secondView.getLocationOnScreen(secondPosition);

        // Rect constructor parameters: left, top, right, bottom
        Rect rectFirstView = new Rect(firstPosition[0], firstPosition[1],
                firstPosition[0] + firstView.getMeasuredWidth(), firstPosition[1] +
                firstView.getMeasuredHeight());
        Rect rectSecondView = new Rect(secondPosition[0], secondPosition[1],
                secondPosition[0] + secondView.getMeasuredWidth(), secondPosition[1] +
                secondView.getMeasuredHeight());
        return rectFirstView.intersect(rectSecondView);
    }


    //handling collision with louie and an 'A'
    private void aObtained() {
        ImageView removeA = null;
        for(ImageView a : aVisibleList){
            if(isViewOverlapping(louie, a)) {
                a.setVisibility(View.GONE);
                //if(numAVisible == 0)
                  //  gameWon(this);
                numAVisible--;
                removeA = a;
            }
            //increase the score here as well, depend on difficulty?
            // high-score?
        }
        if(removeA != null) {
            aVisibleList.remove(removeA);
            updateGame();
        }
    }


    //update the gameboard after an A is obtained
    private void updateGame() {
        Random rnd = new Random();

        //making the game harder as A's are obtained
        int random = rnd.nextInt(2);
        if(random == 0) {
            if(numRange < 9)
                numRange++;
        }
        else {
            if(numSpeed < 9) {
                numSpeed++;
            }
        }

        //repopulating the A randomly that was obtained
        for(int i = 0; i < 1; i++) {
            int rand = rnd.nextInt(25);
            if(aList.get(rand).getVisibility() == View.GONE) {
                aList.get(rand).setVisibility((View.VISIBLE));
                aVisibleList.add(aList.get(rand));
            }
            else
                i--;
        }

        //updating the score
        updateScore();
    }


    //handling collision with louie and a prof
    //private void profCollision(ImageView louie, ImageView prof) {
    private void profCollision() {

        for(ImageView prof : profList) {
            if(isViewOverlapping(louie, prof)) {
                if (numLives > 1) {
                    numLives--;
                    prof.setX(0);
                    prof.setY(0);
                    updateLives();
                } else {
                    numLives = 0;
                    prof.setX(0);
                    prof.setY(0);
                    updateLives();
                    gameOver(this);
                }
            }
        }
    }


    private void gameOver(Context c) {
        final TextView gameOver = new TextView(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("GAME OVER")
                .setMessage("You lost! Click 'Okay' to exit to home screen, or click " +
                        "Highscores to view you highscores.")
                .setView(gameOver)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //also check high-score shit
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Highscores", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(GameActivity.this, HighscoreActivity.class);
                        startActivity(intent);
                    }
                })
                .create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }


    //handle if back is pressed, end game
    @Override
    public void onBackPressed() {
        gameOver(this);
    }


    //update the # of lives remaining
    private void updateLives() {
        decreaseNumLives = "Lives Remaining: " + numLives;
        livesRemaining.setText(decreaseNumLives);
    }

    //algorithm to update score (rewards players for playing at higher difficulty)
    private int scoreAlgorithm() {
        int addScore;
        int livesSelected = Math.abs(10 - startLives);
        addScore = (10*livesSelected) + (10*numSpeed) + (10*numRange) + (10*numProfs);
        return addScore;
    }

    //updating user score on GameActivity screen
    private void updateScore() {
        scoreBoard += scoreAlgorithm();
        currentScore = "Score: " + scoreBoard;
        score.setText(currentScore);
    }


    /**
     * Class to handle Louie movement.
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {

        /**
         * Method to handle user touching screen and move Louie.
         * @param view The view.
         * @param event The event.
         * @return  Boolean value.
         */
        public boolean onTouch(final View view, final MotionEvent event) {
            final int xLoc = (int) event.getRawX();
            final int yLoc = (int) event.getRawY();
            switch (event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams params
                            = (RelativeLayout.LayoutParams)
                            view.getLayoutParams();
                    x = xLoc - params.leftMargin;
                    y = yLoc - params.topMargin;
                    break;

                case MotionEvent.ACTION_UP:
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    break;

                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams
                            = (RelativeLayout.LayoutParams)
                            view.getLayoutParams();
                    layoutParams.leftMargin = xLoc - x;
                    layoutParams.topMargin = yLoc - y;
                    layoutParams.rightMargin = -250;
                    layoutParams.bottomMargin = -250;
                    view.setLayoutParams(layoutParams);
                    break;
                default:
                    break;
            }
            layout.invalidate();
            return true;
        }
    }
}
