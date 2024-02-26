package com.ltimdree.movie.ltimdree.repository;

import com.ltimdree.movie.ltimdree.components.MovieStorageComponent;
import com.ltimdree.movie.ltimdree.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Implementation of the {@link MovieRepository} interface.
 * Retrieves movies from the {@link MovieStorageComponent}.
 */
@Repository
public class MovieRepositoryImpl implements MovieRepository<Movie> {

    @Autowired
    MovieStorageComponent movieStorageComponent;

    /**
     * Retrieves a list of movies from the {@link MovieStorageComponent}.
     *
     * @return The list of movies.
     */
    @Override
    public List<Movie> storageMovies() {
        return movieStorageComponent.storageMovies();
    }
}
