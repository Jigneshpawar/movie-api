package dev.jignesh.movies.service.Impl;

import dev.jignesh.movies.dao.MovieDao;
import dev.jignesh.movies.model.Movie;
import dev.jignesh.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    public MovieDao movieDao;

    public List<Movie> allMovies(){
        return movieDao.getAllMovies();
    }

    public Optional<Movie> movieById(String imdbId){
        return movieDao.getMovieById(imdbId);
    }
}
