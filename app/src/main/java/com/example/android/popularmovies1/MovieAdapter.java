package com.example.android.popularmovies1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Maino96-10022 on 6/3/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder> {

    private ArrayList<Movie> moviesList = new ArrayList<Movie>();
    private Context context;
    private MovieAdapterOnClickHandler mClickHandler;

    public interface MovieAdapterOnClickHandler {
        void onClick(Movie posterClick);
    }

    public MovieAdapter(MovieAdapterOnClickHandler clickHandler, ArrayList<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
        mClickHandler = clickHandler;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;

        public MovieAdapterViewHolder(View view) {
            super(view);

            imageView = (ImageView) view.findViewById(R.id.imageView);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int adapterPosition = getAdapterPosition();
            Movie posterClick = moviesList.get(adapterPosition);
            mClickHandler.onClick(posterClick);
        }
    }

    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.movie_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        return new MovieAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieAdapterViewHolder holder, int position) {
        //Binding data
        final Movie movieView = moviesList.get(position);

        TextView releaseDate = (TextView) inflater.findViewById(R.id.release_date);
        Movie currentMovie = moviesList.get(position);

        SimpleDateFormat simpleDateFormat  = new SimpleDateFormat("2016-09-26T15:57:34Z");
        Date date = null;

        try {
            date = simpleDateFormat.parse(currentMovie.getReleaseDate());
            date.toString();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat newDateFormat= new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss'Z'");
        String finalDate = newDateFormat.format(date);
        
        releaseDate.setText(finalDate);




        Picasso.with(context)
                .load(movieView.getPosterUrl())
                .resize(185, 50)
                .centerCrop()
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public void setMovieList(ArrayList<Movie> mMovieList) {
        this.moviesList.addAll(mMovieList);
        notifyDataSetChanged();
    }
}



