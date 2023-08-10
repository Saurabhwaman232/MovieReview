package com.example.demo.service.request;

import com.example.demo.Domain.Movie;
import com.example.demo.Domain.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewRequest {
    private String movieReview;
    private double rating;
    private Long movieId;
    public Review toReview(){
        return Review.builder().movieReview(movieReview).rating(rating).movie(Movie.builder().id(movieId).build()).build();
    }
}
