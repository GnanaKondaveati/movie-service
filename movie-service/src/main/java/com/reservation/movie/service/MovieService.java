package com.reservation.movie.service;

import com.reservation.movie.data.dto.MovieDTO;

import java.util.List;

public interface MovieService {
    List<MovieDTO> getMoviesByGenre(String name);
    List<MovieDTO> findAllMoviesWithShowTimes();
}
