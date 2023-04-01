package dev.jignesh.movies.dao.Impl;

import dev.jignesh.movies.dao.ReviewDao;
import dev.jignesh.movies.model.Movie;
import dev.jignesh.movies.model.Review;
import dev.jignesh.movies.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDaoImpl implements ReviewDao {

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    public ReviewRepository reviewRepository;

    public Review createReview(String reviewBody, String imdbId){
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;
    }
}
