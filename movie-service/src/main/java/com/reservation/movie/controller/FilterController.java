package com.reservation.movie.controller;

import com.reservation.movie.data.dto.Movie;
import com.reservation.movie.exception.MovieNotFoundException;
import com.reservation.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/filters")
@RequiredArgsConstructor
public class FilterController {

    private final MovieService movieService;

    @GetMapping("/genre")
    public ResponseEntity<List<Movie>> filterByGenre(@RequestParam String name) {
        List<Movie> filteredMovies = movieService.getMoviesByGenre(name);
        if (filteredMovies.isEmpty()) {
            throw new MovieNotFoundException("No movies found for genre: " + name);
        }
        return ResponseEntity.ok(filteredMovies);
    }
}
