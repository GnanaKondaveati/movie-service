package com.reservation.movie.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.reservation.movie.data.model.Movie;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class MockMovieService {

    private List<Movie> mockMovies;

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        // This tells Jackson to handle the Java 8 Date/Time types like OffsetDateTime
        mapper.registerModule(new JavaTimeModule());

        InputStream inputStream = TypeReference.class.getResourceAsStream("/movies.json");
        this.mockMovies = mapper.readValue(inputStream, new TypeReference<List<Movie>>(){});
    }

    public List<Movie> getAllMovies() {
        return mockMovies;
    }
}