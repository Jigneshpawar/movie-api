package dev.jignesh.movies.service.Impl;

import dev.jignesh.movies.dao.ReviewDao;
import dev.jignesh.movies.model.Review;
import dev.jignesh.movies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewDao reviewDao;

    public Review createNewReview(String reviewBody, String imdbId){
        return reviewDao.createReview(reviewBody, imdbId);
    }
}
