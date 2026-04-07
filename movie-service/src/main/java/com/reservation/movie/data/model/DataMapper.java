package com.reservation.movie.data.model;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses= {ShowTimeMapper.class})
public interface DataMapper {
    com.reservation.movie.data.dto.Movie toDto(com.reservation.movie.data.model.Movie movie);

    List<com.reservation.movie.data.dto.Movie> toDtoList(List<com.reservation.movie.data.model.Movie> movies);
}
