package com.example.demo.Repository;

import com.example.demo.Domain.Genre;
import com.example.demo.Domain.Movie;
import com.example.demo.Domain.Genre;
import com.example.demo.Domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
    public Movie findByTitle(String title);
    public List<Movie> findByGenre(Genre genre);
}
