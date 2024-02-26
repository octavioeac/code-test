package com.ltimdree.movie.ltimdree.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltimdree.movie.ltimdree.model.Movie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MovieStorageComponentTest {

    @InjectMocks
    private MovieStorageComponent movieStorageComponent;

    @Mock
    private ResourceLoader resourceLoader;

    @Mock
    private Resource resource;

    @Mock
    private InputStream inputStream;

    @Mock
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void testStorageMovies() throws IOException {
        when(resourceLoader.getResource("classpath:movies.json")).thenReturn(resource);
        when(resource.getInputStream()).thenReturn(inputStream);
        Movie[] moviesArray = {new Movie(/* movie details */)};
        when(objectMapper.readValue(inputStream, Movie[].class)).thenReturn(moviesArray);
        List<Movie> moviesList = movieStorageComponent.storageMovies();
        assertEquals(Arrays.asList(moviesArray), moviesList);
    }
}
