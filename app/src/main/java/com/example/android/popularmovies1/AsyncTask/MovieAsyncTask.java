package com.example.android.popularmovies1.AsyncTask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.popularmovies1.MainActivity;
import com.example.android.popularmovies1.Movie;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maino96-10022 on 6/8/2017.
 */

public class MovieAsyncTask extends AsyncTask <String, Void, List<Movie>> {

    private static final String TAG = MovieAsyncTask.class.getSimpleName();
    private ProgressBar mLoadingIndicator;
    private AsyncTaskInterface listener;

    public MovieAsyncTask(AsyncTaskInterface listener){
        this.listener=listener;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }


    @Override
    protected List<Movie> doInBackground(String... params) {
        List<Movie> result = new ArrayList<Movie>();

        if (params.length == 0) {
            return null;
        }
        try {
            URL url = null;

        }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        List<Movie> data=new ArrayList<>();

        try{

        JSONObject baseJsonResponse = new JSONObject(movieJSON);
        JSONArray movieArray = baseJsonResponse.getJSONArray("items");

        for (int i = 0; i < movieArray.length(); i++) {



    }

        @Override
        protected void onPostExecute(List<Movie>) {

            listener.returnData(List<Movie> moviesList);
        }


}



