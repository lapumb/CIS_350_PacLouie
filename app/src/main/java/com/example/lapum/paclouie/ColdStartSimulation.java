package com.example.lapum.paclouie;

import android.app.Application;
import android.os.SystemClock;

public class ColdStartSimulation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
