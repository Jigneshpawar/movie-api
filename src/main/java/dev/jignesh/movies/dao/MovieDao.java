package dev.jignesh.movies.dao;

import dev.jignesh.movies.model.Movie;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface MovieDao {

    List<Movie> getAllMovies();

    Optional<Movie> getMovieById(String imbdId);

}
