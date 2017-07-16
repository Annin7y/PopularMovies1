package com.example.android.popularmovies1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.popularmovies1.AsyncTask.AsyncTaskInterface;
import com.example.android.popularmovies1.AsyncTask.MovieAsyncTask;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MovieAdapter.MovieAdapterOnClickHandler, AsyncTaskInterface {

    private static final String TAG = MainActivity.class.getSimpleName();

    /**
     * Base URL for the image
     */
    // private static final String BASE_URL = "http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";

    private ArrayList<Movie> simpleJsonMovieData = new ArrayList<>();

    private Context context;

    private RecyclerView mRecyclerView;

    private MovieAdapter movieAdapter;

    RecyclerView.LayoutManager mLayoutManager;

    private TextView mErrorMessageDisplay;

    private ProgressBar mLoadingIndicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_main);
        movieAdapter = new MovieAdapter(this, simpleJsonMovieData, context);
        mRecyclerView.setAdapter(movieAdapter);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mErrorMessageDisplay = (TextView) findViewById(R.id.movie_error_message_display);
        mLoadingIndicator = (ProgressBar) findViewById(R.id.pb_loading_indicator);
        MovieAsyncTask myTask = new MovieAsyncTask(this);
        myTask.execute("most_popular");
    }

    @Override
    public void returnData(ArrayList<Movie> simpleJsonMovieData) {
            movieAdapter = new MovieAdapter(this, simpleJsonMovieData, MainActivity.this);
            mRecyclerView.setAdapter(movieAdapter);

        }


    private void showErrorMessage() {
        /* First, hide the currently visible data */
        mRecyclerView.setVisibility(View.INVISIBLE);
        /* Then, show the error */
        mErrorMessageDisplay.setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(Movie movie) {
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("Movie", movie);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /* Use AppCompatActivity's method getMenuInflater to get a handle on the menu inflater */
        MenuInflater inflater = getMenuInflater();
        /* Use the inflater's inflate method to inflate our menu layout to this menu */
        inflater.inflate(R.menu.main, menu);
        /* Return true so that the menu is displayed in the Toolbar */
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        MovieAsyncTask myTask = new MovieAsyncTask(this);
        switch (item.getItemId()) {
            case R.id.most_popular:
                myTask.execute("most_popular");
                returnData(simpleJsonMovieData );
                return true;

            case R.id.top_rated:
                myTask.execute("top_rated");
                returnData(simpleJsonMovieData);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}