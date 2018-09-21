package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = new Intent(this, StartScreenActivity.class); //change MainActivity.class to whatever the "start screen" will be

        startActivity(intent);
        finish();
    }
}
