package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

/*
    This class is the "press to start" opening screen.
 */
public class StartScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        ConstraintLayout constraintLayout = findViewById(R.id.startscreen);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        //Animation to make text flash
        TextView pressToStart = findViewById(R.id.PressToStart);
        Animation animation = new AlphaAnimation(0.0f, 1.0f);

        //Speed of the flashing
        animation.setDuration(475);
        animation.setStartOffset(50);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        pressToStart.startAnimation(animation);
    }

}
