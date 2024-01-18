package io.example.authapi.models.daos;

import io.example.authapi.models.entities.User;
import io.example.authapi.models.enums.USerRole;

import java.time.LocalDateTime;
import java.util.Date;

public record UserDAO(
        String email,
        USerRole role,
        LocalDateTime createdAt
) {

    public UserDAO(User user){
        this(
                user.getEmail(),
                user.getRole(),
                user.getCreatedAt()
        );
    }
}
