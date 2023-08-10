package com.example.demo.service.response;

import com.example.demo.Domain.Genre;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieResponse {
    private String title;
    private Genre genre;
    private Double rating;
    private List<ReviewResponse> reviews;
}
