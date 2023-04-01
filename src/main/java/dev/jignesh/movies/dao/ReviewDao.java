package dev.jignesh.movies.dao;

import dev.jignesh.movies.model.Review;

public interface ReviewDao {
    Review createReview(String reviewBody, String imdbId);
}
