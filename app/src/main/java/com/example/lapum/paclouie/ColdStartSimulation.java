package com.example.lapum.paclouie;

import android.app.Application;
import android.os.SystemClock;

/**
 * This class is only to simulate a cold start; delete this class
 *     and 'android:name=".ColdStartSimulation"' in AndroidManifest.xml.
 */
public class ColdStartSimulation extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
