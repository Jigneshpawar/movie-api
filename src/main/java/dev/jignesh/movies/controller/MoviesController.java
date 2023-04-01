package dev.jignesh.movies.controller;

import dev.jignesh.movies.model.Movie;
import dev.jignesh.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MoviesController {

    @Autowired
    public MovieService movieService;

    @GetMapping("/getAll")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<List<Movie>> getAllMovies(){

        return new ResponseEntity<>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.movieById(imdbId), HttpStatus.OK);
    }
}
