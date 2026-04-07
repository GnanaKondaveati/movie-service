package com.reservation.movie.controller;

import com.reservation.movie.data.dto.MovieDTO;
import com.reservation.movie.exception.MovieNotFoundException;
import com.reservation.movie.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/filters")
public class FilterController {

    private final MovieService movieService;

    public FilterController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/genre")
    public ResponseEntity<List<MovieDTO>> filterByGenre(@RequestParam String name) {
        List<MovieDTO> filteredMovies = movieService.getMoviesByGenre(name);
        if (filteredMovies.isEmpty()) {
            throw new MovieNotFoundException("No movies found for genre: " + name);
        }
        return ResponseEntity.ok(filteredMovies);
    }
}
