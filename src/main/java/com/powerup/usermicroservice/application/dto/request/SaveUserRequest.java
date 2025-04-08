package com.powerup.usermicroservice.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Schema(description = "User creation request")
public record SaveUserRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        @Schema(description = "User's first name", example = "John")
        String name,

        @NotBlank(message = "Last name is required")
        @Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
        @Schema(description = "User's last name", example = "Doe")
        String lastName,

        @NotBlank(message = "Document ID is required")
        @Pattern(regexp = "^\\d+$", message = "Document ID must contain only numbers")
        @Size(min = 8, max = 10, message = "Document ID must be between 8 and 10 digits")
        @Schema(description = "User's document ID", example = "12345678")
        String documentId,

        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^\\+?\\d+$", message = "Invalid phone number format")
        @Size(min = 10, max = 13, message = "Phone number must be between 10 and 13 digits")
        @Schema(description = "User's phone number", example = "+573001234567")
        String phoneNumber,

        @NotNull(message = "Birth date is required")
        @Past(message = "Birth date must be in the past")
        @Schema(description = "User's birth date (YYYY-MM-DD)", example = "1990-01-15", type = "string", format = "date")
        LocalDate birthDate,

        @NotBlank(message = "Email is required")
        @Email(message = "Invalid email format")
        @Schema(description = "User's email address", example = "john.doe@example.com")
        String email,

        @NotBlank(message = "Password is required")
        @Size(min = 8, message = "Password must be at least 8 characters long")
        @Schema(description = "User's password")
        String password
) {
}