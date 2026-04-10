package com.reservation.movie.data.model;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses= {ShowTimeMapper.class})
public interface DataMapper {

    @Mapping(target = "genres", source = "genres",qualifiedByName = "mapGenres")
    com.reservation.movie.data.dto.Movie toDto(com.reservation.movie.data.model.Movie movie);

    List<com.reservation.movie.data.dto.Movie> toDtoList(List<com.reservation.movie.data.model.Movie> movies);
 //add doc
    @Named("mapGenres")
    default List<String> mapGenres(Set<Genre> genres) {
        if (genres == null) {
            return null;
        }
        return genres.stream()
                .map(Genre::getGenreName) // Extract the name string from the Genre object
                .collect(Collectors.toList());
    }
}
