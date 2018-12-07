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

    /**
     * Game is Running boolean.
     **/
    private boolean gameIsRunning;

    /**
     * X location.
     **/
    private int x;

    /**
     * Y location.
     **/
    private int y;

    /**
     * PacLouie layout.
     **/
    private RelativeLayout layout;

    /**
     * string to show number of lives remaining.
     **/
    private String decreaseNumLives;

    /**
     * string to show current score of the game.
     **/
    private String currentScore;

    /**
     * Score obainted in game.
     **/
    private int scoreBoard = 0;

    /**
     * Variable for the selected number of lives to START game.
     **/
    private final int startLives = SettingsActivity.getCurrentNumLives();

    /**
     * Variable for the number of profs in the game.
     **/
    private int numProfs = SettingsActivity.getCurrentNumProfs();

    /**
     * Variable for speed of profs in game.
     **/
    private int numSpeed = SettingsActivity.getCurrentNumSpeed();

    /**
     * Variable for range of profs in game.
     **/
    private int numRange = SettingsActivity.getCurrentNumRange();

    /**
     * Variable for number of lives in game.
     **/
    private int numLives = SettingsActivity.getCurrentNumLives();

    /**
     * Variable for the number of visible A's.
     **/
    private int numAVisible;

    /**
     * Used to get latest score in Highscore activity in the case that we do
     * not go to HighscoreActivity when GameOver() is called.
     **/
    private static int lastScore;

    /**
     * Professor images.
     */
    private ImageView prof0, prof1, prof2, prof3, prof4,
                        prof5, prof6, prof7, prof8;

    /**
     * Louie image.
     */
    private ImageView louie;

    /**
     * Teachers lounge image.
     */
    private ImageView teachersLounge;

    /**
     * Images for the A's.
     */
    private ImageView a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12,
            a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24;

    /**
     * Text view for the score and the lives remaining.
     */
    private TextView score, livesRemaining;

    /**
     * Array list for the profs.
     */
    private ArrayList<ImageView> profList = new ArrayList<>();

    /**
     * Array list for the A's.
     */
    private ArrayList<ImageView> aList = new ArrayList<>();

    /**
     * Array list for the visible A's.
     */
    private ArrayList<ImageView> aVisibleList = new ArrayList<>();

    /**
     * Gets the latest score.
     * @return The latest score.
     */
    public static int getLastScore() {
        return lastScore;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        gameIsRunning = true;

        //setting lastScore to be initially zero
        lastScore = 0;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = findViewById(R.id.gameView);

        //initializing images (profs, louie, a's)
        instantiateProfs();

        //louie initial start position
        this.louie = findViewById(R.id.gameLouie);
        louie.setX(10);
        louie.setY(200);

        //setting teacherslounge visibility to always visibile
        this.teachersLounge = (ImageView) findViewById(R.id.teacherLounge);
        teachersLounge.setX(0);
        teachersLounge.setY(0);

        //randomly selecting which A's will be in game
        instantiateAs();

        addImageViewsToList();

        //initially setting all profs to not appear (gone)
        for (ImageView prof : profList) {
            prof.setVisibility(View.GONE);
        }

        //initially setting all a's to be gone
        for (ImageView a : aList) {
            a.setVisibility(View.GONE);
        }

        //setting how many profs are visible
        setProfVisibility(numProfs);
        // setting number of A's appearing
        setAVisibility(numProfs, numRange, numSpeed, numLives);

        handleRunables();

        instantiateGameText();

        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(225, 225);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());
    }

    /**
     * Instantiate the score and the lives remaining text views.
     */
    private void instantiateGameText() {

        this.score = findViewById(R.id.scoreText);
        this.livesRemaining = findViewById(R.id.livesText);

        //lives remaining text
        decreaseNumLives = livesRemaining.getText().toString();
        decreaseNumLives = decreaseNumLives + " " + numLives;
        livesRemaining.setText(decreaseNumLives);

        //beginning score text
        currentScore = score.getText().toString();
        currentScore = currentScore + " " + scoreBoard;
        score.setText(currentScore);
    }

    /**
     * Handler for moving profs, prof collisions, collecting A's.
     */
    private void handleRunables() {
        final Handler handler = new Handler();
        final Runnable r = new Runnable() {
            public void run() {
                if (gameIsRunning) {
                    callMoveProf();
                    handler.postDelayed(this, Professor.getRealSpeed(numSpeed));
                }
            }
        };

        final Runnable r2 = new Runnable() {
            @Override
            public void run() {
                if (gameIsRunning) {
                    aObtained();
                    profCollision();
                    loungeCollision();
                    handler.postDelayed(this, 1);
                }
            }
        };

        handler.postDelayed(r, 0);
        handler.postDelayed(r2, 0);
    }

    /**
     * Instantiate prof ImageViews.
     */
    private void instantiateProfs() {
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
    private void instantiateAs() {
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
    private void addImageViewsToList() {
        ImageView[] tempProfList = {prof0, prof1, prof2, prof3, prof4, prof5,
                                    prof6, prof7, prof8};
        Collections.addAll(profList, tempProfList);
        ImageView[] tempAList = {a0, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10,
                                    a11, a12, a13, a14, a15, a16, a17, a18,
                                    a19, a20, a21, a22, a23, a24};
        Collections.addAll(aList, tempAList);
    }

    /**
     * Function to determine which profs are present and need movement.
     */
    public void callMoveProf() {
        for (ImageView prof : profList) {
            if (prof.getVisibility() == View.VISIBLE) {
                moveProf(prof, numRange);
            }
        }
    }

    /**Moves the professor that is being called.
    * @param prof prof the prof that wants to be moved
    * @param range range professors can move
     */
    public void moveProf(final ImageView prof, final int range) {
        int tempRange = range;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        //setting the range
        tempRange = range * 3;

        //difference in x and y
        int dx;
        int dy;
        int rnd;
        //float mult = (float).9;
        int mult = 10;

        //random to choose direction of professor
        Random random = new Random();
        dx = random.nextInt(2);
        dy = random.nextInt(2);
        rnd = random.nextInt(10);

        //applying range to prof movement
        if (rnd >= 5) {
            for (int i = 0; i <= tempRange; i++) {
                if ((prof.getX() + dx * mult) < width) {
                    prof.setX(prof.getX() + dx * mult);
                }
                if ((prof.getY() + dy * mult) < height) {
                    prof.setY(prof.getY() + dy * mult);
                }
            }
        } else {
            for (int i = 0; i <= tempRange; i++) {
                if ((prof.getX() - dx * mult) >= 0) {
                    prof.setX(prof.getX() - dx * mult);
                }
                if ((prof.getY() - dy * mult) >= 0) {
                    prof.setY(prof.getY() - dy * mult);
                }
            }
        }
    }

    /**
     * Randomly generating which profs appear (user selected amount).
     * @param numVisibleProfs The number of profs to make visible.
     */
    public void setProfVisibility(final int numVisibleProfs) {
        Random rnd = new Random();
        for (int i = 0; i < numVisibleProfs; i++) {
            int rand = rnd.nextInt(9);
            if (profList.get(rand).getVisibility() == View.GONE) {
                profList.get(rand).setVisibility(View.VISIBLE);
            } else {
                i--;
            }
        }
    }

    /**
     * Method to set which A's are visible (random).
     * @param profs Number of profs visible.
     * @param range The range of the profs.
     * @param speed The speed of the profs.
     * @param lives The number of lives.
     */
    public void setAVisibility(final int profs, final int range,
                               final int speed, final int lives) {
        Random rnd = new Random();
        int numA = 1 + ((profs / 2) + 2) + ((range / 2) + 2)
                        + ((speed / 2) + 2) + ((lives / 2) + 2);
        numAVisible = numA;
        for (int i = 0; i <= numA; i++) {
            int rand = rnd.nextInt(25);
            if (aList.get(rand).getVisibility() == View.GONE) {
                aList.get(rand).setVisibility((View.VISIBLE));
                aVisibleList.add(aList.get(rand));
            } else {
                i--;
            }
        }
    }

    /**
     * Checking if ImageView's overlap.
     * @param firstView The first view to check.
     * @param secondView The second view to check.
     * @return True if the views are overlapping else false.
     */
    private boolean isViewOverlapping(final ImageView firstView,
                                      final ImageView secondView) {
        int[] firstPosition = new int[2];
        int[] secondPosition = new int[2];

        firstView.getLocationOnScreen(firstPosition);
        secondView.getLocationOnScreen(secondPosition);

        // Rect constructor parameters: left, top, right, bottom
        Rect rectFirstView = new Rect(firstPosition[0], firstPosition[1],
                firstPosition[0] + firstView.getMeasuredWidth(),
                firstPosition[1] + firstView.getMeasuredHeight());
        Rect rectSecondView = new Rect(secondPosition[0], secondPosition[1],
                secondPosition[0] + secondView.getMeasuredWidth(),
                secondPosition[1] + secondView.getMeasuredHeight());
        return rectFirstView.intersect(rectSecondView);
    }

    /**
     * Handling collision with louie and an 'A'.
     */
    private void aObtained() {
        ImageView removeA = null;
        for (ImageView a : aVisibleList) {
            if (isViewOverlapping(louie, a)) {
                a.setVisibility(View.GONE);
                numAVisible--;
                removeA = a;
            }
        }
        if (removeA != null) {
            aVisibleList.remove(removeA);
            //updating score, replacing A, making game harder
            updateGame();
        }
    }

    /**
     * Update the gameboard after an A is obtained.
     */
    private void updateGame() {
        Random rnd = new Random();

        //making the game harder as A's are obtained
        int random = rnd.nextInt(2);
        if (random == 0) {
            if (numRange < 9) {
                numRange++;
            }
        } else {
            if (numSpeed < 9) {
                numSpeed++;
            }
        }

        //repopulating the A randomly that was obtained
        for (int i = 0; i < 1; i++) {
            int rand = rnd.nextInt(25);
            if (aList.get(rand).getVisibility() == View.GONE) {
                aList.get(rand).setVisibility((View.VISIBLE));
                aVisibleList.add(aList.get(rand));
            } else {
                i--;
            }
        }

        //updating the score
        updateScore();
    }

    /**
     *Handling collision with louie and a prof.
     */
    private void profCollision() {

        for (ImageView prof : profList) {
            if (isViewOverlapping(louie, prof)) {
                if (numLives > 1) {
                    numLives--;
                    prof.setX(0);
                    prof.setY(0);
                    updateLives();
                } else {
                    gameOver(this);
                }
            }
        }
    }

    /**
     * Handles collisions with the teachers lounge.
     */
    private void loungeCollision() {
        if (isViewOverlapping(louie, teachersLounge)) {
            gameOver(this);
        }
    }

    /**
     * Handles when the game has ended.
     * @param c The current context.
     */
    private void gameOver(final Context c) {
        final TextView gameOver = new TextView(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("GAME OVER")
                .setMessage("You lost! Click 'Okay' to exit to home screen,"
                        + " or click " + "Highscores to view you highscores.")
                .setView(gameOver)
                .setPositiveButton("Okay",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog,
                                        final int which) {
                        //also check high-score shit
                        Intent intent = new Intent(GameActivity.this,
                                MainActivity.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Highscores",
                        new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(final DialogInterface dialog,
                                        final int which) {
                        //sending score to highscore page
                        Intent intent = new Intent(GameActivity.this,
                                HighscoreActivity.class);
                        intent.putExtra("SCORE", scoreBoard);
                        startActivity(intent);
                    }
                })
                .create();
        //pausing the activity (need to figure this out)
        gameIsRunning = false;

        //setting lives to be zero since we lost
        numLives = 0;
        updateLives();

        //making it so we must click Highscores or Okay, and we exit
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }

    //handle if back is pressed, end game
    @Override
    public void onBackPressed() {
        gameOver(this);
    }


    /**
     * Update the number of lives remaining.
     */
    private void updateLives() {
        decreaseNumLives = "Lives Remaining: " + numLives;
        livesRemaining.setText(decreaseNumLives);
    }

    /**
     * Algorithm to update score
     * (rewards players for playing at higher difficulty).
     * @return The score to add.
     */
    private int scoreAlgorithm() {
        int addScore;
        int livesSelected = Math.abs(10 - startLives);
        addScore = (10 * livesSelected) + (10 * numSpeed)
                + (10 * numRange) + (10 * numProfs);
        return addScore;
    }

    /**
     * Updating user score on GameActivity screen.
     */
    private void updateScore() {
        scoreBoard += scoreAlgorithm();
        currentScore = "Score: " + scoreBoard;
        score.setText(currentScore);

        lastScore = scoreBoard;
    }

    /**
     * Returns the current score.
     * @return The current score.
     */
    public int getScore() {
        return scoreBoard;
    }

    /**
     * Class to handle Louie movement.
     */
    private final class ChoiceTouchListener implements View.OnTouchListener {

        /**
         * Method to handle user touching screen and move Louie.
         *
         * @param view  The view.
         * @param event The event.
         * @return Boolean value.
         */
        public boolean onTouch(final View view, final MotionEvent event) {
            if (gameIsRunning) {
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
            return false;
        }
    }
}
