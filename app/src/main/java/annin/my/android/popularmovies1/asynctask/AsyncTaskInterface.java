package annin.my.android.popularmovies1.asynctask;

import annin.my.android.popularmovies1.model.Movie;

import java.util.ArrayList;

/**
 * Created by Maino96-10022 on 6/10/2017.
 */

public interface AsyncTaskInterface
{
    void returnData(ArrayList<Movie> simpleJsonMovieData);
}


