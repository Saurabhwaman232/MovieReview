package com.example.demo.service;

import com.example.demo.Domain.Movie;
import com.example.demo.Repository.MovieRepository;
import com.example.demo.Domain.Movie;
import com.example.demo.Repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    private MovieRepository movieRepository;

    public AdminService(MovieRepository movieRepository){
        this .movieRepository=movieRepository;
    }
    public Movie addmovie(Movie movie){
        return movieRepository.save(movie);
    }
}
