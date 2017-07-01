package com.example.android.popularmovies1.AsyncTask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.popularmovies1.MainActivity;
import com.example.android.popularmovies1.Movie;
import com.example.android.popularmovies1.MovieAdapter;
import com.example.android.popularmovies1.Utils.NetworkUtils;

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
    private final AsyncTaskInterface listener;
    private MovieAdapter mMovieAdapter;
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

        if (params.length == 0) {
            return null;
        }
        String location = params[0];
        URL movieRequestUrl = NetworkUtils.buildUrl(location);

        try {
            String jsonWeatherResponse = NetworkUtils
                    .makeHttpRequest(movieRequestUrl);

            List simpleJsonMovieData = NetworkUtils
                    .extractFeatureFromJson(MovieAsyncTask.this, jsonWeatherResponse);

            return simpleJsonMovieData;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


        @Override
        protected void onPostExecut (List < Movie > mMovieList) {
            super.onPostExecute(mMovieList);
            if (mMovieList != null) {
                mMovieAdapter.setMovieList(mMovieList);
            }
        }
    }





