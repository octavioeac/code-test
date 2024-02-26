package com.ltimdree.movie.ltimdree.model;

import lombok.*;

/**
 * Represents details of a movie.
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Details {
    /**
     * The title of the movie.
     */
    private String title;

    /**
     * The director of the movie.
     */
    private String director;

    /**
     * The genre of the movie.
     */
    private String genre;
}
