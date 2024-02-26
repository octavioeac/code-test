package com.ltimdree.movie.ltimdree.controller;

import com.ltimdree.movie.ltimdree.exception.NotFoundException;
import com.ltimdree.movie.ltimdree.model.Details;
import com.ltimdree.movie.ltimdree.model.Movie;
import com.ltimdree.movie.ltimdree.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling movie-related endpoints.
 */
@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;

    /**
     * Retrieves all movies.
     *
     * @return ResponseEntity containing the list of movies.
     */
    @Operation(summary = "Get all movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved movies"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/all")
    public ResponseEntity<List<Movie>> getAllMovies() {
        List<Movie> movies = movieService.findAllMovies();
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * Finds movies released in a specific year.
     *
     * @param year The release year of the movies to search for.
     * @return ResponseEntity containing the list of movies released in the specified year.
     */
    @Operation(summary = "Find movies released in a specific year")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved movies"),
            @ApiResponse(responseCode = "404", description = "No movies found for the specified year"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/movies/released")
    public ResponseEntity<List<Movie>> findMoviesReleasedInYear(
            @RequestParam("year") int year) {
        List<Movie> movies = movieService.findMoviesReleasedInYear(year);
        if (movies.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * Finds movies ordered by favorite count.
     *
     * @param typeOrder The type of ordering (asc or desc).
     * @return ResponseEntity containing the list of movies ordered by favorite count.
     */
    @Operation(summary = "Find movies ordered by favorite count")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved movies"),
            @ApiResponse(responseCode = "400", description = "Invalid value for typeOrder parameter"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/movies/orderedByFavoriteCount")
    public ResponseEntity<List<Movie>> findMoviesOrderedByFavoriteCount(
            @Parameter(in = ParameterIn.QUERY, description = "Type of ordering (asc or desc)", required = true,
                    example = "asc")
            @RequestParam("typeOrder") String typeOrder) {
        if (!"asc".equalsIgnoreCase(typeOrder) && !"desc".equalsIgnoreCase(typeOrder)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Movie> movies = movieService.findMoviesOrderedByFavoriteCount(typeOrder);
        return new ResponseEntity<>(movies, HttpStatus.OK);
    }

    /**
     * Finds details of a movie by its ID.
     *
     * @param id The ID of the movie to retrieve details for.
     * @return ResponseEntity containing the details of the movie.
     */
    @Operation(summary = "Find details of a movie by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved movie details"),
            @ApiResponse(responseCode = "404", description = "Movie not found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @GetMapping("/movies/{id}/details")
    public ResponseEntity<Details> findDetailMovie(
            @Parameter(in = ParameterIn.PATH, description = "ID of the movie", required = true)
            @PathVariable("id") String id) {
        try {
            Details details = movieService.findDetailMovie(id);
            return new ResponseEntity<>(details, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
