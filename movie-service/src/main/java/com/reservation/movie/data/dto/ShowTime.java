package com.reservation.movie.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowTime {
    private int showtimeId;
    private String theatreId;
    private ZonedDateTime startTime; // Represents the exact date and time
    private String screenName;
    private boolean showRunning;
    private int movieId;
}
