package com.ltimdree.movie.ltimdree.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetailsTest {

    @Test
    void testConstructorAndGetters() {
        String title = "Movie Title";
        String director = "Movie Director";
        String genre = "Action";
        Details details = new Details(title, director, genre);
        assertEquals(title, details.getTitle());
        assertEquals(director, details.getDirector());
        assertEquals(genre, details.getGenre());
    }

    @Test
    void testSetterAndGetters() {
        String title = "Movie Title";
        String director = "Movie Director";
        String genre = "Action";

        Details details = new Details();
        details.setTitle(title);
        details.setDirector(director);
        details.setGenre(genre);

        assertEquals(title, details.getTitle());
        assertEquals(director, details.getDirector());
        assertEquals(genre, details.getGenre());
    }

    @Test
    void testToString() {
        String title = "Movie Title";
        String director = "Movie Director";
        String genre = "Action";

        Details details = new Details(title, director, genre);
String expectedToString = "Details(title=Movie Title, director=Movie Director, genre=Action)";

        assertEquals(expectedToString, details.toString());
    }
}
