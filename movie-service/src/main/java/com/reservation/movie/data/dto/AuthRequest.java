package com.reservation.movie.data.dto;

public record AuthRequest(
        String username,
        String password
) {}