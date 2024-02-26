package com.ltimdree.movie.ltimdree.repository;
import com.ltimdree.movie.ltimdree.model.Movie;

import java.util.List;

public interface MovieRepository<Movie> {

    /**
     * Retrieves all movies.
     * @return a list of all movies
     */
    List<Movie> storageMovies();
}
