package com.udacity.gradle.builditbigger.backend;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {
    private String myData;

    /**
     * Method that gets the data
     */
    public String getData() {
        return myData;
    }

    /**
     * Method that sets the data
     */
    void setData(String data) {
        myData = data;
    }
}