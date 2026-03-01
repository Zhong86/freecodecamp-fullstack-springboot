package com.zhong.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
  @Autowired
  private MovieRepository movieRepository;

  public List<Movie> allMovies() {
    List<Movie> movies = movieRepository.findAll();
    return movies;
  }
}
