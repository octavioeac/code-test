package com.ltimdree.movie.ltimdree.repository;

import com.ltimdree.movie.ltimdree.components.MovieStorageComponent;
import com.ltimdree.movie.ltimdree.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MovieRepositoryImplTest {

    @Mock
    private MovieStorageComponent movieStorageComponent;

    @InjectMocks
    private MovieRepositoryImpl movieRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testStorageMovies() {
        List<Movie> expectedMovies = new ArrayList<>();
        when(movieStorageComponent.storageMovies()).thenReturn(expectedMovies);
        List<Movie> actualMovies = movieRepository.storageMovies();
        assertEquals(expectedMovies, actualMovies);
        verify(movieStorageComponent, times(1)).storageMovies();
    }
}
