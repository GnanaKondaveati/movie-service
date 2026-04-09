package com.reservation.movie.service;

import com.reservation.movie.data.dto.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getMoviesByGenre(String name);
    List<Movie> findAllMoviesWithShowTimes();
}
