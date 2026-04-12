package com.reservation.movie.service.impl;

import com.reservation.movie.data.dto.Movie;
import com.reservation.movie.data.entity.DataMapper;
import com.reservation.movie.repository.MovieRepository;
import com.reservation.movie.exception.MovieNotFoundException;
import com.reservation.movie.service.MockMovieService;
import com.reservation.movie.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    private final DataMapper mapper;

    private final MockMovieService mockMovieService;

    public MovieServiceImpl(MovieRepository movieRepository, DataMapper mapper, MockMovieService mockMovieService) {
        this.movieRepository = movieRepository;
        this.mapper = mapper;
        this.mockMovieService = mockMovieService;
    }

    @Override
    public List<Movie> getMoviesByGenre(String name) {
        List<com.reservation.movie.data.entity.Movie> movieList = mockMovieService.getAllMovies();
                //movieRepository.findByGenreNameIgnoreCase(name);
        if(movieList.isEmpty()){
            throw new MovieNotFoundException("No movies available for the requested Genre");
        }
        return mapper.toDtoList(movieList);
    }

    @Override
    public List<Movie> findAllMoviesWithShowTimes() {
        List<com.reservation.movie.data.entity.Movie> movies = mockMovieService.getAllMovies();
        //movieRepository.findAllMoviesWithShowTimes();
        if(movies.isEmpty()){
            throw new MovieNotFoundException("No movies available to show");
        }
        return mapper.toDtoList(movies);
    }

}
