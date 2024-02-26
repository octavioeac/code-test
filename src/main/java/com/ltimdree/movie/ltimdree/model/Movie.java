package com.ltimdree.movie.ltimdree.model;

import lombok.*;

import java.util.Map;

/**
 * Represents a movie.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movie {
    /**
     * The unique identifier of the movie.
     */
    private String id;

    /**
     * The URL of the movie picture.
     */
    private String url;

    /**
     * The number of times the movie picture was favorited.
     */
    private Integer favoriteCount;

    /**
     * The release year of the movie.
     */
    private Integer releaseYear;

    /**
     * The votes associated with the movie, containing the number of up and down votes.
     */
    private Map<String, Integer> votes;

    /**
     * The details of the movie, including its title, director, and genre.
     */
    private Details details;
}
