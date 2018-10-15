package com.example.lapum.paclouie;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    private int x;
    private int y;
    private RelativeLayout layout;
    final Random rnd = new Random();
    String str;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        layout = (RelativeLayout) findViewById(R.id.gameView);

        //initializing images
        ImageView prof0 = (ImageView) findViewById(R.id.randomTest0);
        ImageView prof1 = (ImageView) findViewById(R.id.randomTest1);
        ImageView prof2 = (ImageView) findViewById(R.id.randomTest2);
        ImageView prof3 = (ImageView) findViewById(R.id.randomTest3);
        ImageView prof4 = (ImageView) findViewById(R.id.randomTest4);
        ImageView prof5 = (ImageView) findViewById(R.id.randomTest5);
        ImageView louie = (ImageView) findViewById(R.id.gameLouie);


        //initially setting all profs to not appear (gone)
        prof0.setVisibility(View.GONE);
        prof1.setVisibility(View.GONE);
        prof2.setVisibility(View.GONE);
        prof3.setVisibility(View.GONE);
        prof4.setVisibility(View.GONE);
        prof5.setVisibility(View.GONE);


        //"randomly" generating which (stand-in profs) appear (using a stand in hard number)
        for(int i = 0; i < 1; i++) {
            str = "prof" + rnd.nextInt(6);
            if(str.equals("prof0") && prof0.getVisibility() == View.GONE) {
                prof0.setVisibility(View.VISIBLE);
            }
            else if(str.equals("prof1") && prof1.getVisibility() == View.GONE) {
                prof1.setVisibility(View.VISIBLE);
            }
            else if(str.equals("prof2") && prof2.getVisibility() == View.GONE) {
                prof2.setVisibility(View.VISIBLE);
            }
            else if(str.equals("prof3") && prof3.getVisibility() == View.GONE) {
                prof3.setVisibility(View.VISIBLE);
            }
            else if(str.equals("prof4") && prof4.getVisibility() == View.GONE) {
                prof4.setVisibility(View.VISIBLE);
            }
            else if(str.equals("prof5") && prof5.getVisibility() == View.GONE) {
                prof5.setVisibility(View.VISIBLE);
            }
            else {
                i--;
            }
        }

        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(150, 150);
        louie.setLayoutParams(layoutParams);
        louie.setOnTouchListener(new ChoiceTouchListener());
    }

    private final class ChoiceTouchListener implements View.OnTouchListener {
        public boolean onTouch(View view, MotionEvent event) {
            final int X = (int) event.getRawX();
            final int Y = (int) event.getRawY();
            switch(event.getAction() & MotionEvent.ACTION_MASK) {
                case MotionEvent.ACTION_DOWN:
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    x = X - params.leftMargin;
                    y = Y - params.topMargin;
                    break;

                case MotionEvent.ACTION_UP:
                    break;

                case MotionEvent.ACTION_POINTER_DOWN:
                    break;

                case MotionEvent.ACTION_POINTER_UP:
                    break;

                case MotionEvent.ACTION_MOVE:
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
                    layoutParams.leftMargin = X - x;
                    layoutParams.topMargin = Y - y;
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
