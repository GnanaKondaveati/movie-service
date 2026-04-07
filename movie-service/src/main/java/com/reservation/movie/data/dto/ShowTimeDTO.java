package com.reservation.movie.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowTimeDTO {
    private String showtimeId;
    private String theatreId;
    private LocalDateTime startTime; // Represents the exact date and time
    private String screenName;
    private Boolean showRunning;
    private int movieId;
}
