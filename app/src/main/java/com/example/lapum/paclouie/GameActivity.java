package com.example.lapum.paclouie;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    /** string for number of lives remaining in game **/
    private String strNumLives;

    /** string to show number of lives remaining **/
    private String decreaseNumLives;

    /** TODO Need to add javadoc for instance variables. **/
    private int numProfs = SettingsActivity.getCurrentNumProfs();

    /** Variable for speed of profs in game **/
    private int numSpeed = SettingsActivity.getCurrentNumSpeed();

    /** Variable for range of profs in game **/
    private int numRange = SettingsActivity.getCurrentNumRange();

    /** Variable for number of lives in game **/
    private int numLives = SettingsActivity.getCurrentNumLives();

    /** Variable to set the actual speed of the profs movements **/
    private int speed = Professor.getRealSpeed(numSpeed);

    //handler and runnable responsible for constantly moving the profs
    Handler handler = new Handler();
    final Runnable r = new Runnable() {
        public void run() {
            callMoveProf();
            handler.postDelayed(r, speed);
        }
    };


   //Images for profs and louie
    ImageView prof0;
    ImageView prof1;
    ImageView prof2;
    ImageView prof3;
    ImageView prof4;
    ImageView prof5;
    ImageView prof6;
    ImageView prof7;
    ImageView prof8;
    ImageView louie;

    //objects Louie is to achieve
    ImageView a0;
    ImageView a1;
    ImageView a2;
    ImageView a3;
    ImageView a4;
    ImageView a5;
    ImageView a6;
    ImageView a7;
    ImageView a8;
    ImageView a9;
    ImageView a10;
    ImageView a11;
    ImageView a12;
    ImageView a13;
    ImageView a14;
    ImageView a15;
    ImageView a16;
    ImageView a17;
    ImageView a18;
    ImageView a19;
    ImageView a20;
    ImageView a21;
    ImageView a22;
    ImageView a23;
    ImageView a24;


    //text views in upper corners
    TextView highesetScore;
    TextView livesRemaining;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        gameIsRunning = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = (RelativeLayout) findViewById(R.id.gameView);

        //initializing images (profs, louie, a's)
        this.prof0 = (ImageView) findViewById(R.id.prof0);
        this.prof1 = (ImageView) findViewById(R.id.prof1);
        this.prof2 = (ImageView) findViewById(R.id.prof2);
        this.prof3 = (ImageView) findViewById(R.id.prof3);
        this.prof4 = (ImageView) findViewById(R.id.prof4);
        this.prof5 = (ImageView) findViewById(R.id.prof5);
        this.prof6 = (ImageView) findViewById(R.id.prof6);
        this.prof7 = (ImageView) findViewById(R.id.prof7);
        this.prof8 = (ImageView) findViewById(R.id.prof8);
        this.louie = (ImageView) findViewById(R.id.gameLouie);
        this.a0 = (ImageView) findViewById(R.id.a0);
        this.a1 = (ImageView) findViewById(R.id.a1);
        this.a2 = (ImageView) findViewById(R.id.a2);
        this.a3 = (ImageView) findViewById(R.id.a3);
        this.a4 = (ImageView) findViewById(R.id.a4);
        this.a5 = (ImageView) findViewById(R.id.a5);
        this.a6 = (ImageView) findViewById(R.id.a6);
        this.a7 = (ImageView) findViewById(R.id.a7);
        this.a8 = (ImageView) findViewById(R.id.a8);
        this.a9 = (ImageView) findViewById(R.id.a9);
        this.a10 = (ImageView) findViewById(R.id.a10);
        this.a11 = (ImageView) findViewById(R.id.a11);
        this.a12 = (ImageView) findViewById(R.id.a12);
        this.a13 = (ImageView) findViewById(R.id.a13);
        this.a14 = (ImageView) findViewById(R.id.a14);
        this.a15 = (ImageView) findViewById(R.id.a15);
        this.a16 = (ImageView) findViewById(R.id.a16);
        this.a17 = (ImageView) findViewById(R.id.a17);
        this.a18 = (ImageView) findViewById(R.id.a18);
        this.a19 = (ImageView) findViewById(R.id.a19);
        this.a20 = (ImageView) findViewById(R.id.a20);
        this.a21 = (ImageView) findViewById(R.id.a21);
        this.a22 = (ImageView) findViewById(R.id.a22);
        this.a23 = (ImageView) findViewById(R.id.a23);
        this.a24 = (ImageView) findViewById(R.id.a24);

        //text in upper corners (always visible)
        this.highesetScore = (TextView) findViewById(R.id.highscoresText);
        this.livesRemaining = (TextView) findViewById(R.id.livesText);


        //initially setting all profs to not appear (gone)
        prof1.setVisibility(View.GONE);
        prof2.setVisibility(View.GONE);
        prof3.setVisibility(View.GONE);
        prof4.setVisibility(View.GONE);
        prof5.setVisibility(View.GONE);
        prof6.setVisibility(View.GONE);
        prof7.setVisibility(View.GONE);
        prof8.setVisibility(View.GONE);
        prof0.setVisibility(View.GONE);

        //initially setting all a's to be gone
        a0.setVisibility(View.GONE);
        a1.setVisibility(View.GONE);
        a2.setVisibility(View.GONE);
        a3.setVisibility(View.GONE);
        a4.setVisibility(View.GONE);
        a5.setVisibility(View.GONE);
        a6.setVisibility(View.GONE);
        a7.setVisibility(View.GONE);
        a8.setVisibility(View.GONE);
        a9.setVisibility(View.GONE);
        a10.setVisibility(View.GONE);
        a11.setVisibility(View.GONE);
        a12.setVisibility(View.GONE);
        a13.setVisibility(View.GONE);
        a14.setVisibility(View.GONE);
        a15.setVisibility(View.GONE);
        a16.setVisibility(View.GONE);
        a17.setVisibility(View.GONE);
        a18.setVisibility(View.GONE);
        a19.setVisibility(View.GONE);
        a20.setVisibility(View.GONE);
        a21.setVisibility(View.GONE);
        a22.setVisibility(View.GONE);
        a23.setVisibility(View.GONE);
        a24.setVisibility(View.GONE);

        setProfVisibility(numProfs); //setting how many profs are visible
        setAVisibility(numProfs, numRange, numSpeed, numLives); //setting number of A's appearing


        /*
        modifyNumProfs = tvNumProfs.getText().toString();
        modifyNumProfs = modifyNumProfs
                .substring(0, modifyNumProfs.length() - 1);
        modifyNumProfs = modifyNumProfs + ": "
                + SettingsActivity.currentNumProfs;
        tvNumProfs.setText(modifyNumProfs);
         */

        decreaseNumLives = livesRemaining.getText().toString();
        decreaseNumLives = decreaseNumLives.substring(0, decreaseNumLives.length()-1);
        decreaseNumLives = decreaseNumLives + ": " + numLives;
        livesRemaining.setText(decreaseNumLives);

        r.run(); //runs the runnable; ie constantly calling callMoveProf

        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(250, 250);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());
    }


    //function to determine which profs are present and need movement
    public void callMoveProf() {
        if(prof0.getVisibility() == View.VISIBLE)
            moveProf(prof0, numRange);
        if(prof1.getVisibility() == View.VISIBLE)
            moveProf(prof1, numRange);
        if(prof2.getVisibility() == View.VISIBLE)
            moveProf(prof2, numRange);
        if(prof3.getVisibility() == View.VISIBLE)
            moveProf(prof3, numRange);
        if(prof4.getVisibility() == View.VISIBLE)
            moveProf(prof4, numRange);
        if(prof5.getVisibility() == View.VISIBLE)
            moveProf(prof5, numRange);
        if(prof6.getVisibility() == View.VISIBLE)
            moveProf(prof6, numRange);
        if(prof7.getVisibility() == View.VISIBLE)
            moveProf(prof7, numRange);
        if(prof8.getVisibility() == View.VISIBLE)
            moveProf(prof8, numRange);
    }


    /*
    /**Moves the professor that is being called
    * @param ImageView prof the prof that wants to be moved
    * @param int range professors can move
     */
    public void moveProf(ImageView prof, int range) {

        //setting the range
        range = range * 3;

        //difference in x and y
        int dx;
        int dy;
        int rnd;

        //random to choose direction of professor
        Random random = new Random();
        dx = random.nextInt(2);
        dy = random.nextInt(2);
        rnd = random.nextInt(10);

        //applying range to prof movement
        if(rnd >= 5) {
            for(int i = 0; i <= range; i++) {
                prof.setX(prof.getX() + dx * 10);
                prof.setY(prof.getY() + dy * 10);
            }
        }
        else {
            for(int i = 0; i <= range; i++) {
                prof.setX(prof.getX() - dx * 10);
                prof.setY(prof.getY() - dy * 10);
            }
        }

        //handling collisions
        /*if(isViewOverlapping(louie, prof)) {
            profCollision();
            prof.setX(0);
            prof.setY(0);
        } */
        profCollision(louie, prof); //handles collisions with prof
    }

    //randomly generating which profs appear (user selected amount)
    public void setProfVisibility(int numProfs) {
        Random rnd = new Random();
        for (int i = 0; i < numProfs; i++) {
            String str = "prof" + rnd.nextInt(9);
            if (str.equals("prof1") && prof1.getVisibility() == View.GONE) {
                prof1.setVisibility(View.VISIBLE);
            } else if (str.equals("prof2") && prof2.getVisibility()
                    == View.GONE) {
                prof2.setVisibility(View.VISIBLE);
            } else if (str.equals("prof3") && prof3.getVisibility()
                    == View.GONE) {
                prof3.setVisibility(View.VISIBLE);
            } else if (str.equals("prof4") && prof4.getVisibility()
                    == View.GONE) {
                prof4.setVisibility(View.VISIBLE);
            } else if (str.equals("prof5") && prof5.getVisibility()
                    == View.GONE) {
                prof5.setVisibility(View.VISIBLE);
            } else if (str.equals("prof6") && prof6.getVisibility()
                    == View.GONE) {
                prof6.setVisibility(View.VISIBLE);
            } else if (str.equals("prof7") && prof7.getVisibility()
                    == View.GONE) {
                prof7.setVisibility(View.VISIBLE);
            } else if (str.equals("prof8") && prof8.getVisibility()
                    == View.GONE) {
                prof8.setVisibility(View.VISIBLE);
            } else if (str.equals("prof0") && prof0.getVisibility()
                    == View.GONE) {
                prof0.setVisibility(View.VISIBLE);
            } else {
                i--;
            }
        }
    }


    //returns which profs are visible.
    private ImageView[] getProfsVisible() {
        ImageView visible[] = new ImageView[10];
        for(int i = 0; i <= visible.length; i++) {
            if(prof0.getVisibility() == View.VISIBLE) {
                visible[i] = prof0;
            }
            if(prof1.getVisibility() == View.VISIBLE) {
                visible[i] = prof1;
            }
            if(prof2.getVisibility() == View.VISIBLE) {
                visible[i] = prof2;
            }
            if(prof3.getVisibility() == View.VISIBLE) {
                visible[i] = prof3;
            }
            if(prof4.getVisibility() == View.VISIBLE) {
                visible[i] = prof4;
            }
            if(prof5.getVisibility() == View.VISIBLE) {
                visible[i] = prof5;
            }
            if(prof6.getVisibility() == View.VISIBLE) {
                visible[i] = prof6;
            }
            if(prof7.getVisibility() == View.VISIBLE) {
                visible[i] = prof7;
            }
            if(prof8.getVisibility() == View.VISIBLE) {
                visible[i] = prof8;
            }
        }
        return visible;
    }

    //method to set which A's are visible (random)
    public void setAVisibility(int profs, int range, int speed, int lives) {
        Random rnd = new Random();
        int numA = 1 + ((profs/2) + 2) + ((range/2) + 2) + ((speed/2) + 2) + ((lives/2) + 2);
        for(int i = 0; i <= numA; i++) {
            String str = "a" + rnd.nextInt(24);
            if (str.equals("a0") && a0.getVisibility() == View.GONE) {
                a0.setVisibility(View.VISIBLE);
            } else if (str.equals("a1") && a1.getVisibility() == View.GONE) {
                a1.setVisibility(View.VISIBLE);
            } else if (str.equals("a2") && a2.getVisibility() == View.GONE) {
                a2.setVisibility(View.VISIBLE);
            } else if (str.equals("a3") && a3.getVisibility() == View.GONE) {
                a3.setVisibility(View.VISIBLE);
            } else if (str.equals("a4") && a4.getVisibility() == View.GONE) {
                a4.setVisibility(View.VISIBLE);
            } else if (str.equals("a5") && a5.getVisibility() == View.GONE) {
                a5.setVisibility(View.VISIBLE);
            } else if (str.equals("a6") && a6.getVisibility() == View.GONE) {
                a6.setVisibility(View.VISIBLE);
            } else if (str.equals("a7") && a7.getVisibility() == View.GONE) {
                a7.setVisibility(View.VISIBLE);
            } else if (str.equals("a8") && a8.getVisibility() == View.GONE) {
                a8.setVisibility(View.VISIBLE);
            } else if (str.equals("a9") && a9.getVisibility() == View.GONE) {
                a9.setVisibility(View.VISIBLE);
            } else if (str.equals("a10") && a10.getVisibility() == View.GONE) {
                a10.setVisibility(View.VISIBLE);
            } else if (str.equals("a11") && a11.getVisibility() == View.GONE) {
                a11.setVisibility(View.VISIBLE);
            } else if (str.equals("a12") && a12.getVisibility() == View.GONE) {
                a12.setVisibility(View.VISIBLE);
            } else if (str.equals("a13") && a13.getVisibility() == View.GONE) {
                a13.setVisibility(View.VISIBLE);
            } else if (str.equals("a14") && a14.getVisibility() == View.GONE) {
                a14.setVisibility(View.VISIBLE);
            } else if (str.equals("a15") && a15.getVisibility() == View.GONE) {
                a15.setVisibility(View.VISIBLE);
            } else if (str.equals("a16") && a16.getVisibility() == View.GONE) {
                a16.setVisibility(View.VISIBLE);
            } else if (str.equals("a17") && a17.getVisibility() == View.GONE) {
                a17.setVisibility(View.VISIBLE);
            } else if (str.equals("a18") && a18.getVisibility() == View.GONE) {
                a18.setVisibility(View.VISIBLE);
            } else if (str.equals("a19") && a19.getVisibility() == View.GONE) {
                a19.setVisibility(View.VISIBLE);
            } else if (str.equals("a20") && a20.getVisibility() == View.GONE) {
                a20.setVisibility(View.VISIBLE);
            } else if (str.equals("a21") && a21.getVisibility() == View.GONE) {
                a21.setVisibility(View.VISIBLE);
            } else if (str.equals("a22") && a22.getVisibility() == View.GONE) {
                a22.setVisibility(View.VISIBLE);
            } else if (str.equals("a23") && a23.getVisibility() == View.GONE) {
                a23.setVisibility(View.VISIBLE);
            } else if (str.equals("a24") && a24.getVisibility() == View.GONE) {
                a24.setVisibility(View.VISIBLE);
            }
        }
    }


    //returns which A's are visible
    private ImageView[] getAsVisible() {
        ImageView visible[] = new ImageView[25];
        for(int i = 0; i <= visible.length; i++) {
            if (a0.getVisibility() == View.VISIBLE) {
                visible[i] = a0;
            }
            if (a1.getVisibility() == View.VISIBLE) {
                visible[i] = a1;
            }
            if (a2.getVisibility() == View.VISIBLE) {
                visible[i] = a2;
            }
            if (a3.getVisibility() == View.VISIBLE) {
                visible[i] = a3;
            }
            if (a4.getVisibility() == View.VISIBLE) {
                visible[i] = a4;
            }
            if (a5.getVisibility() == View.VISIBLE) {
                visible[i] = a5;
            }
            if (a6.getVisibility() == View.VISIBLE) {
                visible[i] = a6;
            }
            if (a7.getVisibility() == View.VISIBLE) {
                visible[i] = a7;
            }
            if (a8.getVisibility() == View.VISIBLE) {
                visible[i] = a8;
            }
            if (a9.getVisibility() == View.VISIBLE) {
                visible[i] = a9;
            }
            if (a10.getVisibility() == View.VISIBLE) {
                visible[i] = a10;
            }
            if (a11.getVisibility() == View.VISIBLE) {
                visible[i] = a11;
            }
            if (a12.getVisibility() == View.VISIBLE) {
                visible[i] = a12;
            }
            if (a13.getVisibility() == View.VISIBLE) {
                visible[i] = a13;
            }
            if (a14.getVisibility() == View.VISIBLE) {
                visible[i] = a14;
            }
            if (a15.getVisibility() == View.VISIBLE) {
                visible[i] = a15;
            }
            if (a16.getVisibility() == View.VISIBLE) {
                visible[i] = a16;
            }
            if (a17.getVisibility() == View.VISIBLE) {
                visible[i] = a17;
            }
            if (a18.getVisibility() == View.VISIBLE) {
                visible[i] = a18;
            }
            if (a19.getVisibility() == View.VISIBLE) {
                visible[i] = a19;
            }
            if (a20.getVisibility() == View.VISIBLE) {
                visible[i] = a20;
            }
            if (a21.getVisibility() == View.VISIBLE) {
                visible[i] = a21;
            }
            if (a22.getVisibility() == View.VISIBLE) {
                visible[i] = a22;
            }
            if (a23.getVisibility() == View.VISIBLE) {
                visible[i] = a23;
            }
            if (a24.getVisibility() == View.VISIBLE) {
                visible[i] = a24;
            }
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
    private void aObtained(ImageView A) {
        int aCount = getAsVisible().length;
        if(A.getVisibility() == View.VISIBLE) {
            A.setVisibility(View.GONE);
            if(aCount == 0) {
                gameWon(this);
            }
            //increase the score here as well, depend on difficulty?
            // high-score?
        }
    }


    //handling collision with louie and a prof
    private void profCollision(ImageView louie, ImageView prof) {
        if(isViewOverlapping(louie, prof)) {
            if (numLives > 1) {
                numLives--;
                prof.setX(0);
                prof.setY(0);
                updateLives();
            } else {
                gameOver(this);
                //maybe check a "gameover page" rather than a popup message.
                // (there are intent issues)
            }
        }
    }


    //function to show popup dialog (Maybe???)
    private void gameOver(Context c) {
        final TextView gameOver = new TextView(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("GAME OVER")
                .setMessage("You lost! Click 'Okay' to exit to home screen.")
                .setView(gameOver)
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //also check high-score shit
                        Intent intent = new Intent(GameActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                })
                .create();
        dialog.show();
        updateLives();
    }


    //you won
    private void gameWon(Context c) {
        final TextView gameWon = new TextView(c);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setTitle("GAME WON!")
                .setMessage("You collected all the A's! You won the game! " +
                        "Press Okay to go back to main screen, " +
                        "or highscores to see highscores page")
                .setView(gameWon)
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
        dialog.show();
    }

    private void updateLives() {
        /*
        SettingsActivity.currentNumLives++;
                    strNumLives = Integer
                            .toString(SettingsActivity.currentNumLives);
                    modifyNumLives = tvNumLives.getText().toString();
                    modifyNumLives = modifyNumLives
                            .substring(0, modifyNumLives.length()
                            - (strNumLives.length()));
                    modifyNumLives = modifyNumLives
                            + SettingsActivity.currentNumLives;
                    tvNumLives.setText(modifyNumLives);
         */
        strNumLives = Integer .toString(numLives);
        decreaseNumLives = livesRemaining.getText().toString();
        decreaseNumLives = decreaseNumLives.substring(0, decreaseNumLives.length() -
                (strNumLives.length()));
        decreaseNumLives = decreaseNumLives + numLives;
        livesRemaining.setText(decreaseNumLives);

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
