package com.example.android.popularmovies1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Movie movie= intent.getParcelableExtra("Movie");

        String posterUrl = movie.getPosterUrl();
        String originalTitle = movie.getOriginalTitle();
        String movieOverview = movie.getMovieOverview();
        Double voteAverage = movie.getVoteAverage();
        String releaseDate = movie.getReleaseDate();

    }
}
