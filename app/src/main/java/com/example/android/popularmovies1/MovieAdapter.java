package com.example.android.popularmovies1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maino96-10022 on 6/3/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> moviesList;

    public MovieAdapter(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }

    public class MovieAdapterViewHolder extends RecyclerView.ViewHolder {

    }
    @Override
    public MovieAdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {



    @Override
    public int getItemCount() {
        if (null == moviesList) return 0;
        return moviesList.size();
    }
}



