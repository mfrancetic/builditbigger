package com.udacity.jokedisplaylibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class JokeDisplayFragment extends Fragment {

    private String joke;
    private final String jokeKey = "joke";

    public JokeDisplayFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        /* Inflate the view */
        View rootView = inflater.inflate(R.layout.fragment_joke_display, container, false);

        TextView jokeTextView = rootView.findViewById(R.id.joke_text_view);

        if (getActivity() != null) {
            /* Check if the savedInstanceState exists.  */
            if (savedInstanceState != null) {
                /* If the savedInstanceState exists, retrieve the saved joke */
                joke = savedInstanceState.getString(jokeKey);
            } else if (getActivity().getIntent() != null){
                /* If the savedInstanceState doesn't exist, retrieve the joke from the intent */
                Intent intent = getActivity().getIntent();
                joke = intent.getStringExtra(jokeKey);
            }
            /* Set the text of the jokeTextView to the joke */
            jokeTextView.setText(joke);
        }
        return rootView;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(jokeKey, joke);
        super.onSaveInstanceState(outState);
    }
}