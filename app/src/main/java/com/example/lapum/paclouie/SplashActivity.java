package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Opening class to display the start screen activity.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(final @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //change MainActivity.class to whatever the "start screen" will be
        Intent intent = new Intent(this, StartScreenActivity.class);

        startActivity(intent);
        finish();
    }
}
