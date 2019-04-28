package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.util.Pair;
import android.widget.Toast;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.udacity.joketellinglibrary.JokeTellingClass;
import com.udacity.gradle.builditbigger.backend.MyBean;
import com.udacity.gradle.builditbigger.backend.MyEndpoint;


import com.udacity.jokedisplaylibrary.JokeDisplayActivity;


import java.io.IOException;

class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;

    private JokeTellingClass jokeTellingClass;

    private Context context;

    String joke;


//
//    @Override
//    protected String doInBackground(Context context) {
//

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
//                    .setRootUrl("http://127.0.0.1:8080/_ah/api/")
//                    .setRootUrl("https://192.168.2.145:8080/_ah/api")
                    .setRootUrl("http://10.0.2.2:8080/_ah/api")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        context = params[0].first;
        joke = params[0].second;

//        jokeTellingClass = new JokeTellingClass();

        try {
            return myApiService.getJoke().execute().getData();

//            return myApiService.sayHi(name).execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {

        super.onPostExecute(result);
//        result = joke;
//        if (result != null) {
//            Intent intent = new Intent(context, JokeDisplayActivity.class);
//            intent.putExtra("joke", result);
//            context.startActivity(intent);
//        }
    }
}