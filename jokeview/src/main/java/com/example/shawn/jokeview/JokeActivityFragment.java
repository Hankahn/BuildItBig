package com.example.shawn.jokeview;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Shawn on 11/10/2015.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_joke, container, false);

        Intent sourceIntent = getActivity().getIntent();
        String joke = sourceIntent.getStringExtra(JokeActivity.JOKE_KEY);

        TextView jokeTextView = (TextView)root.findViewById(R.id.joke_text_view);

        if(joke != null && joke.length() > 0) {
            jokeTextView.setText(joke);
        }

        return root;
    }

}
