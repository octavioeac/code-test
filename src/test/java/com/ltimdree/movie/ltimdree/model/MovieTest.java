package com.ltimdree.movie.ltimdree.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MovieTest {

    @Test
    void testConstructorAndGetters() {
        // Arrange
        String id = "1";
        String url = "https://example.com/movie.jpg";
        Integer favoriteCount = 10;
        Integer releaseYear = 2022;
        Map<String, Integer> votes = new HashMap<>();
        votes.put("up", 5);
        votes.put("down", 3);
        Details details = new Details("Movie Title", "Director Name", "Genre");

        // Act
        Movie movie = new Movie(id, url, favoriteCount, releaseYear, votes, details);

        // Assert
        assertNotNull(movie);
        assertEquals(id, movie.getId());
        assertEquals(url, movie.getUrl());
        assertEquals(favoriteCount, movie.getFavoriteCount());
        assertEquals(releaseYear, movie.getReleaseYear());
        assertEquals(votes, movie.getVotes());
        assertEquals(details, movie.getDetails());
    }

    @Test
    void testSetterAndGetters() {
        // Arrange
        Movie movie = new Movie();

        String id = "2";
        String url = "https://example.com/movie2.jpg";
        Integer favoriteCount = 15;
        Integer releaseYear = 2023;
        Map<String, Integer> votes = new HashMap<>();
        votes.put("up", 7);
        votes.put("down", 2);
        Details details = new Details("Movie Title 2", "Director Name 2", "Genre 2");

        // Act
        movie.setId(id);
        movie.setUrl(url);
        movie.setFavoriteCount(favoriteCount);
        movie.setReleaseYear(releaseYear);
        movie.setVotes(votes);
        movie.setDetails(details);

        // Assert
        assertEquals(id, movie.getId());
        assertEquals(url, movie.getUrl());
        assertEquals(favoriteCount, movie.getFavoriteCount());
        assertEquals(releaseYear, movie.getReleaseYear());
        assertEquals(votes, movie.getVotes());
        assertEquals(details, movie.getDetails());
    }

    @Test
    void testToString() {
        // Arrange
        String id = "3";
        String url = "https://example.com/movie3.jpg";
        Integer favoriteCount = 20;
        Integer releaseYear = 2024;
        Map<String, Integer> votes = new HashMap<>();
        votes.put("up", 10);
        votes.put("down", 5);
        Details details = new Details("Movie Title 3", "Director Name 3", "Genre 3");

        Movie movie = new Movie(id, url, favoriteCount, releaseYear, votes, details);

        // Act
        String expectedToString = "Movie(id=3, url=https://example.com/movie3.jpg, favoriteCount=20, " +
                "releaseYear=2024, votes={up=10, down=5}, details=Details(title=Movie Title 3, " +
                "director=Director Name 3, genre=Genre 3))";

        // Assert
        assertEquals(expectedToString, movie.toString());
    }
}
