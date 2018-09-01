package com.example.jokelib;

import java.util.Arrays;
import java.util.List;


public final class Joke {

    public static final String JOKE_EXTRA = "joke";
    private static final List<String> jokes = Arrays.asList("What's the difference between ignorance and apathy?\nI don't know and I don't care.",
            "What lies at the bottom of the ocean and twitches?\nA nervous wreck.",
            "What do you call an everyday potato?\nA commentator.",
            "What's a dyslexic agnostic insomniac?\nSomeone who lies awake at night wondering if there's a dog.");



public static String getJoke(){
        int jokeNo = (int) (Math.random()*(jokes.size()));
        return jokes.get(jokeNo);
    }
}
