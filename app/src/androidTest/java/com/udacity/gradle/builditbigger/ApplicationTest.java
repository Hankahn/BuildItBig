package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.util.Pair;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {

    public ApplicationTest() {
        super(Application.class);
    }

    public void testAsyncTask() {
        try {
            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();

            jokeTask.execute(new Pair<>(getContext(), ""));
            String joke = jokeTask.get(30, TimeUnit.SECONDS);
            //fail(joke);
            //assertTrue("Joke is not empty", joke.isEmpty());
            assertFalse("Joke is empty", joke.isEmpty());
        } catch (TimeoutException toe) {
            fail("Timed out");
        } catch (Exception e){
            fail(e.toString());
        }
    }

}