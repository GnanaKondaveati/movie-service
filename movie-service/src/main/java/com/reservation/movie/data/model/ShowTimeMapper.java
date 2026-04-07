package com.reservation.movie.data.model;

import com.reservation.movie.data.dto.ShowTimeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ShowTimeMapper {
    ShowTimeDTO toDTO(ShowTime showTime);
    List<ShowTimeDTO> toDTOList(List<ShowTime> showTimes);
}
