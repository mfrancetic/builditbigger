package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
//import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.jokedisplaylibrary.JokeDisplayActivity;
import com.udacity.joketellinglibrary.JokeTellingClass;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private String joke;

    private String jokeKey = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        if (savedInstanceState != null) {
//            joke = savedInstanceState.getString(jokeKey);
//        }
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        outState.putString(jokeKey, joke);
//        super.onSaveInstanceState(outState);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void tellJoke(View view) {

//        if (joke == null) {
            EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
            endpointsAsyncTask.execute();
            try {
                joke = endpointsAsyncTask.get();
            } catch (Exception e) {
                Log.e("exception", "exception is" + e);
            }
//        }

        Intent intent = new Intent(this, JokeDisplayActivity.class);
        intent.putExtra(jokeKey, joke);
        startActivity(intent);

    }
}
