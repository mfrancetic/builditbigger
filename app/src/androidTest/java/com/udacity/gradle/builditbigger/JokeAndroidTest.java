package com.udacity.gradle.builditbigger;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotSame;
import static junit.framework.Assert.assertTrue;

import android.content.Context;
import android.support.test.espresso.IdlingResource;
import android.support.test.espresso.base.IdlingResourceRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.runner.AndroidJUnitRunner;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;


@RunWith(AndroidJUnit4.class)
public class JokeAndroidTest {

    private IdlingResource idlingResource;

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asyncTask_returnsString() throws ExecutionException, InterruptedException {

        Context context = activityTestRule.getActivity().getBaseContext();
        String joke = "Joke 1";

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

        endpointsAsyncTask.execute(new Pair<>(context, joke));

        String result = endpointsAsyncTask.get();

//        String result = endpointsAsyncTask.get();

//        Log.i("result is", "result is" + result);

//
        assertNotSame("", result);
    }
}
