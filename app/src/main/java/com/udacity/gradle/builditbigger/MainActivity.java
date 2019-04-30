package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.udacity.jokedisplaylibrary.JokeDisplayActivity;

public class MainActivity extends AppCompatActivity {

    /* Tag for log messages */
    private final static String LOG_TAG = MainActivity.class.getSimpleName();

    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Inflate the menu; this adds items to the action bar if it is present. */
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Method that executes an endpointsAsyncTask, retrieves a joke, and creates an intent to
     * open the JokeDisplayActivity
     */
    public void tellJoke(View view) {
        String jokeKey = "joke";

        /* Create and execute an EndpointsAsyncTask */
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();
        try {
            joke = endpointsAsyncTask.get();
        } catch (Exception e) {
            Log.e(LOG_TAG, "Exception " + e);
        }

        /* Create and start an intent to open the JokeDisplayActivity */
        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(jokeKey, joke);
        startActivity(intent);
    }
}