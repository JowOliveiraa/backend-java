package com.meuprojeto.Api.dto;

import com.meuprojeto.Api.models.Department;
import com.meuprojeto.Api.models.User;

public record UserDTO(
        Long id,
        String name,
        String email,
        Department department
) {
        public UserDTO(User user) {
                this(user.getId(), user.getName(), user.getEmail(), user.getDepartment());
        }

}
