package dev.jignesh.movies.repository;

import dev.jignesh.movies.model.UserCredentials;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CredentialRepository extends MongoRepository<UserCredentials, ObjectId> {

    Optional<UserCredentials> findByUsername(String username);
}
