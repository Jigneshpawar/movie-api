package dev.jignesh.movies.service;

import dev.jignesh.movies.model.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;


public interface MovieService {

    List<Movie> allMovies();

    Optional<Movie> movieById(String imdbId);
}
