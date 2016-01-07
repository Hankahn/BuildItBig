package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.UiThreadTest;
import android.test.mock.MockContext;
import android.util.Pair;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

/**
 * Created by Shawn on 11/16/2015.
 */
public class EndpointsAsyncTaskTest {

    /*@Test
    public void testAsyncTask() throws Exception {
        try {
            Context context = new MockContext();

            EndpointsAsyncTask jokeTask = new EndpointsAsyncTask();

            jokeTask.execute(new Pair<>(context, ""));
            String joke = jokeTask.get(30, TimeUnit.SECONDS);
            assertFalse(joke.isEmpty());
            //assertEquals("Joke is empty string", joke);
        } catch (TimeoutException toe) {
            fail("Timed out");
        } catch (Exception e){
            fail(e.toString());
        }
    }*/

}