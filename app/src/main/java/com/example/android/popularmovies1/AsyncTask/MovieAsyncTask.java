package com.example.android.popularmovies1.AsyncTask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.popularmovies1.Movie;
import com.example.android.popularmovies1.MovieAdapter;
import com.example.android.popularmovies1.Utils.NetworkUtils;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Maino96-10022 on 6/8/2017.
 */

public class MovieAsyncTask extends AsyncTask <String, Void, ArrayList<Movie>> {

    private static final String TAG = MovieAsyncTask.class.getSimpleName();
    private ProgressBar mLoadingIndicator;
    private AsyncTaskInterface listener;
    public MovieAdapter movieAdapter;

    public MovieAsyncTask(AsyncTaskInterface listener) {
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
     //   mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    protected ArrayList<Movie> doInBackground(String... params) {

        if (params.length == 0) {
            return null;
        }
        String sortMode = params[0];
        URL movieRequestUrl = NetworkUtils.buildUrl(sortMode);

        try {
            String jsonMovieResponse = NetworkUtils
                    .makeHttpRequest(movieRequestUrl);

            ArrayList simpleJsonMovieData = NetworkUtils
                    .extractFeatureFromJson(jsonMovieResponse);

            return simpleJsonMovieData;


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        @Override
        protected void onPostExecute(ArrayList<Movie > mMovieList) {
            super.onPostExecute(mMovieList);
            if (mMovieList != null) {
                listener.returnData(mMovieList);
            }
        }
    }






