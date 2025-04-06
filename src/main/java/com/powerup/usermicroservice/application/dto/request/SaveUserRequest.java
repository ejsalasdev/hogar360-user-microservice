package com.powerup.usermicroservice.application.dto.request;

import java.time.LocalDate;

public record SaveUserRequest(
        String name,
        String lastName,
        String documentId,
        String phoneNumber,
        LocalDate birthDate,
        String email,
        String password
        
) {
}
