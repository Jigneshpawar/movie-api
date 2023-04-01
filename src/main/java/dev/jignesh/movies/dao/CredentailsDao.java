package dev.jignesh.movies.dao;

import dev.jignesh.movies.model.UserCredentials;
import org.springframework.http.HttpStatus;

public interface CredentailsDao {

    HttpStatus saveUser(UserCredentials userCredentials);

}
