package com.udacity.joketellinglibrary;

import java.util.Random;

public class JokeTellingClass {

    public String getJoke() {
        {
            String currentJoke;

            String[] jokes = {
                    "Doctor: \"I'm sorry but you suffer from a terminal illness and have only 10 to live.\" \n Patient: \"What do you mean, 10? 10 what? Months? Weeks?!\" \n Doctor: \"Nine.\"",

                    "My old aunts would come and tease me at weddings: \"Well Sarah? Do you think you’ll be next?\" \n We’ve settled this quickly once I’ve started doing the same to them at funerals.",

                    "A doctor accidentally prescribes his patient a laxative instead of a coughing syrup. \n Three days later the patient comes for a check-up and the doctor asks: \"Well? Are you still coughing?\" \n The patient replies: \"No. I'm afraid to.\"",

                    "Job interviewer: \"And where would you see yourself in five years’ time Mr. Jeffries?\" Mr. Jeffries: \"Personally I believe my biggest weakness is in listening.\"",

                    "\"Can you please hold my hand?\"A mother asks her son: \"Anton, do you think I’m a bad mom?\" \n Son: \"My name is Paul.\"",

                    "Two donkeys are standing at a roadside, one asks the other: \"So, shall we cross?\" \n The other shakes his head: \"No way, look at what happened to the zebra.\"",

                    "Guest to the waiter: \"Can you bring me what the lady at the next table is having?\" \n Waiter: “Sorry, sir, but I’m pretty sure she wants to eat it herself.\"",

                    "\"Mom, where do tampons go?\" \n \"Where the babies come from, darling.\"\n In the stork?\"",

                    "A husband and a wife sit at the table, having dinner. The woman drops a bit of tomato sauce on her white top. \"Oh no, I look like a pig!\"\n The man nods, \"And you dropped tomato sauce on your top!\"",

                    "Husband: \"Wow, honey, you look really different today. Did you do something to your hair?\" \n Wife: \"Michael, I’m over here!\"",


                    "One of the most wonderful things in life is to wake up and enjoy a cuddle with somebody; unless you are in prison."
            };

            Random random = new Random();

            currentJoke = jokes[random.nextInt(jokes.length)];

            return currentJoke;
        }
    }
}
