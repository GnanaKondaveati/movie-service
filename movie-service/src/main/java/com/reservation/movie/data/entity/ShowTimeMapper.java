package com.reservation.movie.data.entity;

import org.mapstruct.Mapper;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ShowTimeMapper {
    com.reservation.movie.data.dto.ShowTime toDTO(com.reservation.movie.data.entity.ShowTime showTime);
    List<com.reservation.movie.data.dto.ShowTime> toDTOList(List<com.reservation.movie.data.entity.ShowTime> showTimes);

    // MapStruct will automatically use this method when it sees OffsetDateTime -> ZonedDateTime
    default ZonedDateTime mapOffsetToZoned(OffsetDateTime offsetDateTime) {
        if (offsetDateTime == null) {
            return null;
        }
        // Convert to ZonedDateTime using system default or a specific ZoneId
        return offsetDateTime.atZoneSameInstant(ZoneId.systemDefault());
    }
}
