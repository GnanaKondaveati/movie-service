package com.reservation.movie.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private int id;
    private String movieName;
    private String description;
    private int runTimeInHrs;
    private String posterUrl;
    private List<String> genres;// conveys to which genre movie belongs, it can be 1 or more than 1
    private List<ShowTimeDTO> showTimes;
}
