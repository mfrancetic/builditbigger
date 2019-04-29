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

    public JokeDisplayFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_joke_display, container, false);

        TextView jokeTextView = rootView.findViewById(R.id.joke_text_view);
        
        if (getActivity()!= null) {
            Intent intent = getActivity().getIntent();
            String joke = intent.getStringExtra("joke");
            jokeTextView.setText(joke);
        }

        return rootView;
    }
}
