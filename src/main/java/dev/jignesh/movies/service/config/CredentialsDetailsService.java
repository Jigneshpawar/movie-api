package dev.jignesh.movies.service.config;

import dev.jignesh.movies.model.UserCredentials;
import dev.jignesh.movies.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@Component
public class CredentialsDetailsService implements UserDetailsService {

    @Autowired
    private CredentialRepository credentialRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredentials> userCredentials = credentialRepository.findByUsername(username);
        return userCredentials.map(CredentialsInfoService::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found" +username));
    }
}
