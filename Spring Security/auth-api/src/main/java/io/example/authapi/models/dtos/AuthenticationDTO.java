package io.example.authapi.models.dtos;

public record AuthenticationDTO(
        String email,
        String password
) {
}
