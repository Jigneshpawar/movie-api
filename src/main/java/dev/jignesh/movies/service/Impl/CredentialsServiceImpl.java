package dev.jignesh.movies.service.Impl;

import dev.jignesh.movies.dao.CredentailsDao;
import dev.jignesh.movies.model.UserCredentials;
import dev.jignesh.movies.service.CredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceImpl implements CredentialsService {

    @Autowired
    private CredentailsDao credentailsDao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public HttpStatus addUser (UserCredentials userCredentials){
        userCredentials.setPassword(passwordEncoder.encode(userCredentials.getPassword()));
        credentailsDao.saveUser(userCredentials);
        return HttpStatus.CREATED;
    }
}
