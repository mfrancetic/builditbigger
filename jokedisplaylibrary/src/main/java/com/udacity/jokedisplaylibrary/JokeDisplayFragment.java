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

    private String jokeKey = "joke";

    public JokeDisplayFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_display, container, false);

        TextView jokeTextView = rootView.findViewById(R.id.joke_text_view);
        
        if (getActivity()!= null) {

            if (savedInstanceState != null) {
                joke = savedInstanceState.getString(jokeKey);
            } else {
                Intent intent = getActivity().getIntent();
                joke = intent.getStringExtra("joke");
            }

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
