package com.example.android.popularmovies1;

import android.os.AsyncTask;
import android.view.View;

/**
 * Created by Maino96-10022 on 6/5/2017.
 */

public class MovieAsyncTask extends AsyncTask<String, Void, String[]> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mLoadingIndicator.setVisibility(View.VISIBLE);
    }

    @Override
    protected String[] doInBackground(String... params) {

            /* If there's no zip code, there's nothing to look up. */
        if (params.length == 0) {
            return null;
        }

}
