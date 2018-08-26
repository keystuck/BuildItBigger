package com.example.androidjokelib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jokelib.Joke;

public class JokeDisplayActivity extends AppCompatActivity {

    private TextView jokeView;
    private TextView punchlineView;
    private TextView errorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        jokeView = findViewById(R.id.tv_joke);

        punchlineView = findViewById(R.id.tv_punchline);
        punchlineView.setVisibility(View.GONE);

        errorView = findViewById(R.id.tv_error);
        errorView.setVisibility(View.GONE);

        Intent incomingIntent = getIntent();
        if (!incomingIntent.hasExtra(Joke.JOKE_EXTRA)){
            showError();
        } else {
            display(incomingIntent.getStringExtra(Joke.JOKE_EXTRA));
        }
    }

    private void display(String fullJoke){
        if (fullJoke.equals(getResources().getString(R.string.no_joke)) || fullJoke.isEmpty()){
            showError();
        } else {
            int stringBreakpoint = fullJoke.indexOf("\n");
            if (stringBreakpoint != -1) {
                String setup = fullJoke.substring(0, stringBreakpoint);
                String punch = fullJoke.substring(stringBreakpoint + 1);
                jokeView.setText(setup);
                punchlineView.setVisibility(View.VISIBLE);
                punchlineView.setText(punch);
            } else {
                //if it's a one-line joke
                jokeView.setText(fullJoke);
            }
        }
    }

    public void showError(){
        jokeView.setVisibility(View.GONE);
        errorView.setVisibility(View.VISIBLE);
    }
}
