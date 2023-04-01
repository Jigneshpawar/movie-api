package dev.jignesh.movies.dao.Impl;

import dev.jignesh.movies.dao.MovieDao;
import dev.jignesh.movies.model.Movie;
import dev.jignesh.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MovieDaoImpl implements MovieDao {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(String imdbId){
        return movieRepository.findByImdbId(imdbId);
    }
}
