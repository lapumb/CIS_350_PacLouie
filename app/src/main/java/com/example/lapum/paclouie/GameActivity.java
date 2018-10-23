package com.example.lapum.paclouie;

import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


import java.util.Random;

/**
 * The PacLouie game activity.
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

    /** TODO Need to add javadoc for instance variables. **/
    private int numProfs = SettingsActivity.currentNumProfs;

    /** TODO Need to add javadoc for instance variables. **/
    //String str;

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



        //"randomly" generating which (stand-in profs)
        // appear (using a stand in hard number)
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

        RelativeLayout.LayoutParams layoutParams
                = new RelativeLayout.LayoutParams(600, 600);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());

        //onStart();

    }

    /*
    @override
    */
    protected void onResume(){
        super.onResume();
        callMoveProf();
    }
    public void callMoveProf(){
        //while game is running
        int i = 0;
        while(i < 10000){
            if(prof0.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof0);
            if(prof1.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof1);
            if(prof2.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof2);
            if(prof3.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof3);
            if(prof4.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof4);
            if(prof5.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof5);
            if(prof6.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof6);
            if(prof7.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof7);
            if(prof8.getVisibility() == View.VISIBLE)
                moveProf(System.currentTimeMillis(), prof8);
            i++;
        }

    }


    @Override
    protected void onActivityResult(final int requestCode,
                                    final int resultCode, final Intent data) {
        /*if(requestCode == SETTINGS_RESULT) {
            numProfs = data.getIntExtra("numProfs", 0);
        } */
    }

    /*
    Moves the professor that is being called
    @param long callTime is the time of calling this method
    @param ImageView prof the prof that wants to be moved
     */
    public void moveProf(long callTime, ImageView prof){

        //current time
        long now = System.currentTimeMillis();
        //difference in x and y
        int dx = 0;
        int dy = 0;

        //random to choose direction of professor
        Random random = new Random();
        dx = random.nextInt(2);
        dy = random.nextInt(2);

        //only moves prof if a second has passed
        if(now >= callTime + 1000){
            if (prof.getVisibility() == View.VISIBLE){
                prof.setX(prof.getX()+ dx * 10);
                prof.setY(prof.getY() + dy * 10);
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
