package com.reservation.movie.data.model;

import com.reservation.movie.data.dto.MovieDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses= {ShowTimeMapper.class})
public interface DataMapper {
    MovieDTO toDto(Movie movie);

    List<MovieDTO> toDtoList(List<Movie> movies);
}
