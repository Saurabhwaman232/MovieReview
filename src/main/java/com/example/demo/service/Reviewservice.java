package com.example.demo.service;

import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.ReviewRepository;
import com.example.demo.Domain.Movie;
import com.example.demo.Domain.Review;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Repository.ReviewRepository;
import com.example.demo.service.response.ReviewResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class Reviewservice {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MovieRepository movieRepository;
    public void addReview(Review review) {
        Movie movie = movieRepository.findById(review.getMovie().getId()).orElse(null);
        reviewRepository.save(review);
        //need to optimized
        //exception handling.
        if (movie != null) {
            Double average = reviewRepository.getReviewAverage(movie.getId());
            movie.setRating(average);
            movieRepository.save(movie);
        }
    }
    public ReviewResponse getReviewById(Long reviewId) {

        Optional<Review> review= reviewRepository.findById(reviewId);
        return review.map(Review::toReviewResponse).orElse(null);

    }
}
