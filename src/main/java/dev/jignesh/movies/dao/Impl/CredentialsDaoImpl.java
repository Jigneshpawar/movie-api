package dev.jignesh.movies.dao.Impl;

import dev.jignesh.movies.dao.CredentailsDao;
import dev.jignesh.movies.model.UserCredentials;
import dev.jignesh.movies.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public class CredentialsDaoImpl implements CredentailsDao {

    @Autowired
    private CredentialRepository credentialRepository;


    public HttpStatus saveUser (UserCredentials userCredentials){

        credentialRepository.save(userCredentials);
        return HttpStatus.CREATED;
    }
}
