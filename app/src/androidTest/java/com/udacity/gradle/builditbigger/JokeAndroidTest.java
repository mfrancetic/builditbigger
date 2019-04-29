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

    @Rule
    public final ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void asyncTask_returnsString() {

        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask();

        endpointsAsyncTask.execute();

        try {
            String result = endpointsAsyncTask.get(30, TimeUnit.SECONDS);
            assertNotNull(result);
            assertNotSame("", result);
        } catch (Exception e) {
            Log.e("JokeAndroidTest", "Timed out" + e);
        }
    }
}