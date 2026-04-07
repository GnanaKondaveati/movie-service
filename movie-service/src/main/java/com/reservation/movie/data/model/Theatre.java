package com.reservation.movie.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int theatreId;
    @Column(nullable = false, unique = true)
    private String name;
    @Column(name= "locality", nullable = false)
    private String locality;
    @Column(name= "building_name", nullable = false)
    private String buildingName;
}
