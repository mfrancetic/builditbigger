package com.udacity.joketellinglibrary;

import java.util.Random;

public class JokeTellingClass {

    public String getJoke() {
        {
            String currentJoke;

            String[] jokes = {"Joke 1", "Joke 2", "Joke 3"};

            Random random = new Random();

            currentJoke = jokes[random.nextInt(jokes.length)];

            return currentJoke;
        }
    }
}
