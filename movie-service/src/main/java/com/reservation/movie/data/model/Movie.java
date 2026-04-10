package com.reservation.movie.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "movie_name", nullable = false)
    private String movieName;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "run_time_in_hrs", nullable = false)
    private int runTimeInHrs;
    @Column(name = "poster_url", nullable = false)
    private String posterUrl;

    @ManyToMany
    @JoinTable(name = "movie_genres",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres;
    @OneToMany(mappedBy = "movie")
    @Column(name ="show_times")
    private List<ShowTime> showTimes;
}
