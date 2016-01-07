package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;

import com.example.shawn.builditbigger.backend.myApi.MyApi;
import com.example.shawn.jokeview.JokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Shawn on 11/16/2015.
 */
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

    private static MyApi myApiService = null;
    private Context mContext = null;

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if(myApiService == null) {
            try {
                MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        //.setRootUrl("http://10.0.2.2:8080/_ah/api/")
                        .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                        //.setRootUrl(mContext.getString(R.string.endPointUrl))
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?>
                                                           abstractGoogleClientRequest)
                                    throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });

                myApiService = builder.build();
            } catch (Exception ex) {
                return ex.getMessage();
            }
        }

        mContext = params[0].first;

        try {
            return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        Intent intent = new Intent(mContext, JokeActivity.class);

        intent.putExtra(JokeActivity.JOKE_KEY, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        mContext.startActivity(intent);
    }

}
