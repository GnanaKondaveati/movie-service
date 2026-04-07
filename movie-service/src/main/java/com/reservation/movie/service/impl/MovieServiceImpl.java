package com.reservation.movie.service.impl;

import com.reservation.movie.data.dto.Movie;
import com.reservation.movie.data.model.DataMapper;
import com.reservation.movie.data.repository.MovieRepository;
import com.reservation.movie.exception.MovieNotFoundException;
import com.reservation.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final DataMapper mapper;

    @Override
    public List<Movie> getMoviesByGenre(String name) {
        List<com.reservation.movie.data.model.Movie> movieList = movieRepository.findByGenreNameIgnoreCase(name);
        if(movieList.isEmpty()){
            throw new MovieNotFoundException("No movies available for the requested Genre");
        }
        return mapper.toDtoList(movieList);
    }

    @Override
    public List<Movie> findAllMoviesWithShowTimes() {
        List<com.reservation.movie.data.model.Movie> movies = movieRepository.findAllMoviesWithShowTimes();
        if(movies.isEmpty()){
            throw new MovieNotFoundException("No movies available to show");
        }
        return mapper.toDtoList(movies);
    }

}
