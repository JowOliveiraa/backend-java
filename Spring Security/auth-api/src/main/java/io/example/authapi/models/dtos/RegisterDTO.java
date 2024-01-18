package io.example.authapi.models.dtos;

import io.example.authapi.models.enums.USerRole;
import org.antlr.v4.runtime.misc.NotNull;

public record RegisterDTO(
        String email,
        String password,
        USerRole role
) {
}
