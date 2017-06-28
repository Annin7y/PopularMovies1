package com.example.android.popularmovies1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private ImageView posterImage;
    private TextView title;
    private TextView overview;
    private TextView vote;
    private TextView date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        posterImage = (ImageView) findViewById(R.id.imageView);
        title = (TextView) findViewById(R.id.original_title);
        overview = (TextView) findViewById(R.id.overview);
        vote = (TextView) findViewById(R.id.vote_average);
        date = (TextView) findViewById(R.id.release_date);

        Intent intent = getIntent();
        Movie movie= intent.getParcelableExtra("Movie");

        String posterImage = movie.getPosterUrl();
        String title = movie.getOriginalTitle();
        String overview = movie.getOverview();
        Double vote = movie.getVoteAverage();
        

    }
}
