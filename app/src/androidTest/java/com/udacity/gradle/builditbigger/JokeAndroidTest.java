package com.udacity.gradle.builditbigger;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNotSame;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import java.util.concurrent.TimeUnit;

@RunWith(AndroidJUnit4.class)
public class JokeAndroidTest {

    /* Tag for log messages */
    private final static String LOG_TAG = JokeAndroidTest.class.getSimpleName();

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    /**
     * Test that checks if the EndpointsAsyncTask returns a valid String
     */
    @Test
    public void asyncTask_returnsString() {
        /* Execute the endpointsAsyncTask */
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();
        endpointsAsyncTask.execute();

        /* Check if the result from the endpointsAsyncTask is null or empty */
        try {
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);
            assertNotNull(result);
            assertNotSame("", result);
        } catch (Exception e) {
            Log.e(LOG_TAG, "Timed out" + e);
        }
    }
}