package com.ltimdree.movie.ltimdree.components;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltimdree.movie.ltimdree.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Component for loading and storing movie data.
 */
@Component
public class MovieStorageComponent {

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    ObjectMapper objectMapper;

    /**
     * Retrieves a list of movies from a JSON file.
     * @return a list of movies
     */
    @Bean
    public List<Movie> storageMovies() {
        Resource resource = resourceLoader.getResource("classpath:movies.json");
        List<Movie> moviesList = null;
        try {
            moviesList = Arrays.asList(objectMapper.readValue(resource.getInputStream(), Movie[].class));
            System.out.println("Number of movies: " + moviesList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return moviesList;
    }
}
