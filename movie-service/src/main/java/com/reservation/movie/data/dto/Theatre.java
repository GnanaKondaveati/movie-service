package com.reservation.movie.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Theatre {

    private int theatreId;
    private String name;
    private String locality;
    private String buildingName;
}


