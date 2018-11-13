package com.example.lapum.paclouie;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

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


        r.run(); //runs the runnable; ie constantly calling callMoveProf

        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(600, 600);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());
    }


    //function to determine which profs are present and need movement
    public void callMoveProf(){
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
