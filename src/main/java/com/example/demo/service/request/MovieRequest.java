package com.example.demo.service.request;

import com.example.demo.Domain.Genre;
import com.example.demo.Domain.Genre;
import com.example.demo.Domain.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String title;
    private Genre Genre;
    public Movie toMovie(){
        return Movie.builder().title(title).genre(Genre).rating(0.0).build();
    }

}
