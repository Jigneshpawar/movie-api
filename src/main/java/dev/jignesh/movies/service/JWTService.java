package dev.jignesh.movies.service;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;

public interface JWTService {

    String generateToken(String username);
    String extractUsername(String token);
    Boolean validateToken(String token, UserDetails userDetails);

}
