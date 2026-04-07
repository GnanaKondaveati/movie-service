package com.reservation.movie.service;

import com.reservation.movie.data.dto.MovieDTO;
import com.reservation.movie.data.model.DataMapper;
import com.reservation.movie.data.model.Movie;
import com.reservation.movie.data.repository.MovieRepository;
import com.reservation.movie.exception.MovieNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepository movieRepository;

    private final DataMapper mapper;

    @Override
    public List<MovieDTO> getMoviesByGenre(String name) {
        List<Movie> movieList = movieRepository.findByGenreName(name);
        if(movieList.isEmpty()){
            throw new MovieNotFoundException("No movies available for the requested Genre");
        }
        return mapper.toDtoList(movieList);
    }

    @Override
    public List<MovieDTO> findAllMoviesWithShowTimes() {
        List<Movie> movies = movieRepository.findAllWithActiveShowTimes();
        if(movies.isEmpty()){
            throw new MovieNotFoundException("No movies available to show");
        }
        return mapper.toDtoList(movies);
    }

}
