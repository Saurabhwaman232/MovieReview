package com.example.demo.Domain;
 import com.example.demo.service.response.MovieResponse;
 import com.example.demo.service.response.MovieResponse;
 import lombok.*;

 import javax.persistence.*;
 import java.io.Serializable;
 import java.util.List;

 @Entity
 @Table(name="movie_table")
 @NoArgsConstructor
 @AllArgsConstructor
 @Builder
 @ToString
 @Getter
 @Setter
public class Movie implements Serializable{
     @Id
     @Column(name ="id", nullable = false)
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String title;
     @Enumerated(EnumType.STRING)
     private Genre genre;
     private Double rating;
     @OneToMany(mappedBy = "movie")
     private List<Review> reviews;

     public MovieResponse toMovieResponse(){
             return MovieResponse.builder().genre(this.genre).title(this.title).rating(this.rating).reviews(Review.toReviewResponse(this.reviews)).build();
}
 }
