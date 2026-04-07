package com.reservation.movie.data.repository;

import com.reservation.movie.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.showTimings WHERE m.id = :id")
    List<Movie> findAllWithActiveShowTimes();

    List<Movie> findByGenreName(String genreName);
}
