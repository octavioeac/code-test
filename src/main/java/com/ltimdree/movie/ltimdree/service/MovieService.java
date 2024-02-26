package com.ltimdree.movie.ltimdree.service;

import com.ltimdree.movie.ltimdree.exception.NotFoundException;
import com.ltimdree.movie.ltimdree.model.Details;
import com.ltimdree.movie.ltimdree.model.Movie;
import com.ltimdree.movie.ltimdree.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    /**
     * Retrieves all movies.
     * @return a list of all movies
     */
    public List<Movie> findAllMovies() {
        return movieRepository.storageMovies();
    }

    /**
     * Retrieves movies ordered by favorite count.
     * @param typeOrder the type of ordering (asc or des)
     * @return a list of movies ordered by favorite count
     */
    public List<Movie> findMoviesOrderedByFavoriteCount(String typeOrder) {
        return (List<Movie>) movieRepository.storageMovies().stream()
                .sorted(typeOrder.equalsIgnoreCase("des") ?
                        Comparator.comparingInt(Movie::getFavoriteCount).reversed()
                        : Comparator.comparingInt(Movie::getFavoriteCount))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves movies released in a specific year.
     * @param year the release year
     * @return a list of movies released in the specified year
     */
    public List<Movie> findMoviesReleasedInYear(int year) {
        List<Movie> movieList = movieRepository.storageMovies();
        return movieList.stream()
                .filter(movie -> movie.getReleaseYear() == year)
                .collect(Collectors.toList());
    }

    /**
     * Retrieves details of a movie by its ID.
     * @param id the ID of the movie
     * @return details of the movie
     * @throws NotFoundException if the movie with the specified ID is not found
     */
    public Details findDetailMovie(String id) {
        List<Movie> listMovie = movieRepository.storageMovies();
        return listMovie.stream()
                .filter(movie -> movie.getId().equals(id))
                .map(Movie::getDetails)
                .findAny()
                .orElseThrow(() -> new NotFoundException(String.format("The movie with id : %s not found", id)));
    }



}