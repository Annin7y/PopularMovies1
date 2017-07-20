package com.example.android.popularmovies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    ImageView poster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie movie = getIntent().getExtras().getParcelable("Movie");
        poster = (ImageView) findViewById(R.id.imageView);

        Picasso.with(this)
                .load(movie.getPosterUrl())
                .into(poster);

        TextView originalTitle = (TextView) findViewById(R.id.original_title);
        originalTitle.setText(movie.getOriginalTitle());

        TextView movieOverview = (TextView) findViewById(R.id.movie_overview);
        movieOverview.setText(movie.getMovieOverview());

        TextView voteAverage = (TextView) findViewById(R.id.vote_average);
        voteAverage.setText(movie.getVoteAverage());

        TextView releaseDate = (TextView) findViewById(R.id.release_date);
        releaseDate.setText(movie.getReleaseDate());

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
m
        try {
            date = simpleDateFormat.parse(movie.getReleaseDate());
            date.toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat newDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String finalDate = newDateFormat.format(date);

        releaseDate.setText(finalDate);


    }
}