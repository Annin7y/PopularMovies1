package com.example.android.popularmovies1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Base URL for the image
     */
    private static final String BASE_URL = "http://image.tmdb.org/t/p/w185";

    private ImageView imageView;

    private RecyclerView mRecyclerView;

    private MovieAdapter mMoviesAdapter;

    RecyclerView.LayoutManager recyclerViewLayoutManager;

    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);

        imageView = (ImageView) findViewById(R.id.imageView);

        Picasso.with(this)
                .load(BASE_URL)
                .into(imageView);

    }
}
