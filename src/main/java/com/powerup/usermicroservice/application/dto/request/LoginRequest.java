package com.powerup.usermicroservice.application.dto.request;

public record LoginRequest(
        String email,
        String password
) {
}
