package com.reservation.movie.data.repository;

import com.reservation.movie.data.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Integer> {
    @Query("SELECT DISTINCT m FROM Movie m JOIN FETCH m.showTimes")
    List<Movie> findAllMoviesWithShowTimes();

    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN FETCH m.genres g " +
            "WHERE LOWER(g.genreName) = LOWER(:genreName)")
    List<Movie> findByGenreNameIgnoreCase(@Param("genreName") String genreName);
}
