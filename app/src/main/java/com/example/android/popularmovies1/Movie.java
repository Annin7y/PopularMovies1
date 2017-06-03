package com.example.android.popularmovies1;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Maino96-10022 on 6/3/2017.
 */

public class Movie implements Parcelable {

    /**
     * Image URL
     */
    private String posterUrl;

    /**
     * Title of the movie
     */
    private String originalTitle;

    /**
     * Overview of the movie
     */
    private String Overview;

    /**
     * Movie rating
     */
    private double voteAverage;

    /**
     * Movie release date
     */
    private String releaseDate;

    public Movie(String posterUrl, String originalTitle, String Overview, Double voteAverage, String releaseDate) {
        this.posterUrl = posterUrl;
        this.originalTitle = originalTitle;
        this.Overview = Overview;
        this.voteAverage = voteAverage;
        this.releaseDate = releaseDate;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDate() {
        return releaseDate;
    }

    public String getOverview() {
        return Overview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    protected Movie(Parcel in) {
        posterUrl = in.readString();
        originalTitle = in.readString();
        Overview = in.readString();
        voteAverage = in.readDouble();
        releaseDate = in.readString();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posterUrl);
        dest.writeString(originalTitle);
        dest.writeString(Overview);
        dest.writeDouble(voteAverage);
        dest.writeString(releaseDate);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
