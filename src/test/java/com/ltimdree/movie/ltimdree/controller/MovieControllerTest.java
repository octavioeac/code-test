package com.ltimdree.movie.ltimdree.controller;

import com.ltimdree.movie.ltimdree.exception.NotFoundException;
import com.ltimdree.movie.ltimdree.model.Details;
import com.ltimdree.movie.ltimdree.model.Movie;
import com.ltimdree.movie.ltimdree.service.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllMovies() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
        when(movieService.findAllMovies()).thenReturn(movies);
        ResponseEntity<List<Movie>> response = movieController.getAllMovies();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());
    }

    @Test
    void testFindMoviesReleasedInYear() {
        int year = 2022;
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
        when(movieService.findMoviesReleasedInYear(year)).thenReturn(movies);
        ResponseEntity<List<Movie>> response = movieController.findMoviesReleasedInYear(year);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());
    }

    @Test
    void testFindMoviesOrderedByFavoriteCount() {
        String typeOrder = "asc";
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie());
        when(movieService.findMoviesOrderedByFavoriteCount(typeOrder)).thenReturn(movies);
        ResponseEntity<List<Movie>> response = movieController.findMoviesOrderedByFavoriteCount(typeOrder);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(movies, response.getBody());
    }

    @Test
    void testFindDetailMovie() {
        String id = "1";
        Details details = new Details();
        when(movieService.findDetailMovie(id)).thenReturn(details);

        ResponseEntity<Details> response = movieController.findDetailMovie(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(details, response.getBody());
    }

    @Test
    void testFindDetailMovie_NotFound() {
        String id = "2";
        when(movieService.findDetailMovie(id)).thenThrow(new NotFoundException());

        ResponseEntity<Details> response = movieController.findDetailMovie(id);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
