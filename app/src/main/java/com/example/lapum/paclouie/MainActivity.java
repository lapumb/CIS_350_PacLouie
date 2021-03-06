package com.example.lapum.paclouie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Home screen activity.
 */
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //start the game activity
        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(MainActivity.this,
                        GameActivity.class);
                startActivity(intent);


            }
        });

        //go to the 'about' information
        Button aboutButton = (Button) findViewById(R.id.aboutBtn);
        aboutButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Intent intent = new Intent(MainActivity.this,
                        AboutActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent intent = new Intent(this, SettingsActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_difficulty) {
            Intent intent = new Intent(this, DifficultyActivity.class);
            startActivity(intent);
        }

        if (id == R.id.action_highscores) {
            Intent intent = new Intent(this, HighscoreActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //handling back press on MainActivity
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(
                MainActivity.this, StartScreenActivity.class);
        startActivity(intent);
    }
}
