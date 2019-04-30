package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.joketellinglibrary.JokeTellingClass;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)
public class MyEndpoint {
    /**
     * An endpoint method that returns a joke supplied from the JokeTellingClass library
     */
    @ApiMethod(name = "getJoke")
    public MyBean getJoke() {
        MyBean response = new MyBean();

        /* Get the joke from the jokeTellingClass and set the data of the response  */
        JokeTellingClass jokeTellingClass = new JokeTellingClass();
        String joke = jokeTellingClass.getJoke();
        response.setData(joke);
        return response;
    }
}