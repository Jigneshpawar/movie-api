package dev.jignesh.movies.service;

import dev.jignesh.movies.model.Review;

public interface ReviewService {
    Review createNewReview(String reviewBody, String imdbId);
}
