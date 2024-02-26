package com.ltimdree.movie.ltimdree.service;

import com.ltimdree.movie.ltimdree.exception.NotFoundException;
import com.ltimdree.movie.ltimdree.model.Details;
import com.ltimdree.movie.ltimdree.model.Movie;
import com.ltimdree.movie.ltimdree.repository.MovieRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MovieServiceTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieService movieService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllMovies() {
        // Arrange
        List<Movie> expectedMovies = new ArrayList<>();
        when(movieRepository.storageMovies()).thenReturn(expectedMovies);

        // Act
        List<Movie> actualMovies = movieService.findAllMovies();

        // Assert
        assertEquals(expectedMovies, actualMovies);
        verify(movieRepository, times(1)).storageMovies();
    }

    @Test
    void testFindMoviesOrderedByFavoriteCount() {
        // Arrange
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1", "url1", 10, 2000, null, null));
        movies.add(new Movie("2", "url2", 20, 2000, null, null));
        when(movieRepository.storageMovies()).thenReturn(movies);

        // Act
        List<Movie> sortedMovies = movieService.findMoviesOrderedByFavoriteCount("asc");

        // Assert
        assertEquals(2, sortedMovies.size());
        assertEquals("1", sortedMovies.get(0).getId());
        assertEquals("2", sortedMovies.get(1).getId());
    }

    @Test
    void testFindMoviesReleasedInYear() {
        // Arrange
        int year = 2000;
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1", "url1", 10, 2000, null, null));
        movies.add(new Movie("2", "url2", 20, 2001, null, null));
        when(movieRepository.storageMovies()).thenReturn(movies);

        // Act
        List<Movie> moviesReleasedInYear = movieService.findMoviesReleasedInYear(year);

        // Assert
        assertEquals(1, moviesReleasedInYear.size());
        assertEquals("1", moviesReleasedInYear.get(0).getId());
    }

    @Test
    void testFindDetailMovie() {
        // Arrange
        String id = "1";
        Details expectedDetails = new Details("Title", "Director", "Genre");
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1", "url1", 10, 2000, null, expectedDetails));
        when(movieRepository.storageMovies()).thenReturn(movies);

        // Act
        Details actualDetails = movieService.findDetailMovie(id);

        // Assert
        assertEquals(expectedDetails, actualDetails);
    }

    @Test
    void testFindDetailMovieNotFound() {
        // Arrange
        String id = "999";
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("1", "url1", 10, 2000, null, null));
        when(movieRepository.storageMovies()).thenReturn(movies);

        // Act and Assert
        assertThrows(NotFoundException.class, () -> movieService.findDetailMovie(id));
    }
}
