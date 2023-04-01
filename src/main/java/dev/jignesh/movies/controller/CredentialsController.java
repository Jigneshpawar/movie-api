package dev.jignesh.movies.controller;

import dev.jignesh.movies.model.JWTAuth;
import dev.jignesh.movies.model.UserCredentials;
import dev.jignesh.movies.service.CredentialsService;
import dev.jignesh.movies.service.JWTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/credentials")
public class CredentialsController {

    @Autowired
    CredentialsService credentialsService;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("/adduser")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public HttpStatus createCredentials(@RequestBody UserCredentials userCredentials){
        credentialsService.addUser(userCredentials);
        return HttpStatus.CREATED;
    }

    @PostMapping("/generateJWTToken")
    public String jwtToken(@RequestBody JWTAuth jwtAuth){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtAuth.getUsername(), jwtAuth.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(jwtAuth.getUsername());
        }else{
            throw new UsernameNotFoundException("invalid user!");
        }
    }
}
