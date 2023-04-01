package dev.jignesh.movies.service;

import dev.jignesh.movies.model.UserCredentials;
import org.springframework.http.HttpStatus;

public interface CredentialsService {

    HttpStatus addUser(UserCredentials userCredentials);

}
