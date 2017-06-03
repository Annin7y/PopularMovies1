package com.example.android.popularmovies1;

/**
 * Created by Maino96-10022 on 6/3/2017.
 */

public class Movie {

    /**
     * Base URL for the image
     */
    private static final String BASE_URL = "http://image.tmdb.org/t/p/w185";

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
    private String mOverview;

    /**
     * Movie rating
     */
    private double voteAverage;

    /**
     * Movie release date
     */
    private String releaseDate;

    public Movie(String PosterUrl, String OriginalTitle, String Overview, Double VoteAverage, String ReleaseDate) {
        posterUrl = PosterUrl;
        originalTitle = OriginalTitle;
        mOverview = Overview;
        voteAverage = VoteAverage;
        releaseDate = ReleaseDate;
    }

    public String getPosterUrl() {
        return BASE_URL + posterUrl;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getDate() {
        return releaseDate;
    }

    public String getOverview() {
        return mOverview;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
}
