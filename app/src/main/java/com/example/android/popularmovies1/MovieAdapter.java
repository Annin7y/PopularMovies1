package com.example.android.popularmovies1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.lang.System.load;

/**
 * Created by Maino96-10022 on 6/3/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private ArrayList<Movie> moviesList;
    private Context context;

    public MovieAdapter(ArrayList<Movie> moviesList) {

        this.moviesList = moviesList;
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

            public MovieViewHolder(View view) {
                super(view);
                imageView= (ImageView) view.findViewById(R.id.imageView);
            }
    }
    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_list_item, parent, false);

        return new MovieViewHolder(itemView);

    }
    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = moviesList.get(position);

      //  String BASE_URL = "http://image.tmdb.org/t/p/w185//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg";


     Picasso.with(context)
         .load(movie.getPosterUrl())
         .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        if (null == moviesList) return 0;
        return moviesList.size();
    }
}



