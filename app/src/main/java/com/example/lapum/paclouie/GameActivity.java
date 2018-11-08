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

    /** Variable for random value. **/
    private final Random rnd = new Random();

    /** Variable for number of professors in game **/
    private int numProfs = SettingsActivity.currentNumProfs;

    /** Variable for speed of profs in game **/
    private int numSpeed = SettingsActivity.currentNumSpeed;

    /** Variable for range of profs in game **/
    private int numRange = SettingsActivity.currentNumRange;

    /** Variable for number of lives in game **/
    private int numLives = SettingsActivity.currentNumLives;

    /** Variable to set the actual speed of the profs movements **/
    private int speed = getRealSpeed(numSpeed);

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

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        gameIsRunning = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = (RelativeLayout) findViewById(R.id.gameView);

        //initializing images
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


        //randomly generating which profs
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

        r.run();

        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(600, 600);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());
    }


    //method returns the actual speed we want the profs to move
    public int getRealSpeed(int speed) {
        //variable to manipulate speed selected
        int realSpeed = 0;

        //setting physical speed
        if(speed == 1)
            realSpeed = 880;
        else if(speed == 2)
            realSpeed = 780;
        else if(speed == 3)
            realSpeed = 680;
        else if(speed == 4)
            realSpeed = 580;
        else if(speed == 5)
            realSpeed = 480;
        else if(speed == 6)
            realSpeed = 380;
        else if(speed == 7)
            realSpeed = 280;
        else if(speed == 8)
            realSpeed = 180;
        else if(speed == 9)
            realSpeed = 80;

        return realSpeed;
    }

    //function to determine which profs are present and need movement
    public void callMoveProf(){
        if(prof0.getVisibility() == View.VISIBLE)
            moveProf(prof0, numSpeed, numRange);
        if(prof1.getVisibility() == View.VISIBLE)
            moveProf(prof1, numSpeed, numRange);
        if(prof2.getVisibility() == View.VISIBLE)
            moveProf(prof2, numSpeed, numRange);
        if(prof3.getVisibility() == View.VISIBLE)
            moveProf(prof3, numSpeed, numRange);
        if(prof4.getVisibility() == View.VISIBLE)
            moveProf(prof4, numSpeed, numRange);
        if(prof5.getVisibility() == View.VISIBLE)
            moveProf(prof5, numSpeed, numRange);
        if(prof6.getVisibility() == View.VISIBLE)
            moveProf(prof6, numSpeed, numRange);
        if(prof7.getVisibility() == View.VISIBLE)
            moveProf(prof7, numSpeed, numRange);
        if(prof8.getVisibility() == View.VISIBLE)
            moveProf(prof8, numSpeed, numRange);
    }


    /*
    /**Moves the professor that is being called
    * @param long callTime is the time of calling this method
    * @param ImageView prof the prof that wants to be moved
     */
    public void moveProf(ImageView prof, int speed, int range) {

        //setting the range
        range = range * 2;

        //difference in x and y
        int dx;
        int dy;
        int rnd;

        //random to choose direction of professor
        Random random = new Random();
        dx = random.nextInt(2);
        dy = random.nextInt(2);
        rnd = random.nextInt(11);

        //applying range to prof movement
        if(rnd >= 5) {
            for(int i = 0; i < range; i++) {
                prof.setX(prof.getX() + dx * 10);
                prof.setY(prof.getY() + dy * 10);
            }
        }
        else {
            for(int i = 0; i < range; i++) {
                prof.setX(prof.getX() - dx * 10);
                prof.setY(prof.getY() - dy * 10);
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
            }
            layout.invalidate();
            return true;
        }
    }
}
