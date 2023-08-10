package com.example.demo.Domain;

import com.example.demo.service.response.ReviewResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.demo.Repository.ReviewRepository;
import com.example.demo.service.response.ReviewResponse;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;


@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Review {
    @Id
    @Column (name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String movieReview;
    private double rating;
    @ManyToOne
    @JoinColumn(name ="movie_id",nullable=false)
    @JsonIgnore
    private Movie movie;
    private Date createDate;
    private Date updatedDate;
    public static ReviewResponse toReviewResponse(Review review){
        return ReviewResponse.builder().review(review.movieReview).rating(review.rating).build();
    }
    public static List<ReviewResponse> toReviewResponse(List<Review>reviewList){
        if(Objects.isNull(reviewList))
            return new ArrayList<>();
        else
            return reviewList.stream().map(Review::toReviewResponse).collect(Collectors.toList());
    }
}
