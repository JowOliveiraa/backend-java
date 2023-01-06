package com.meuprojeto.Api.dto;

import com.meuprojeto.Api.models.Department;
import jakarta.validation.constraints.NotBlank;

public record DepartmentDTO(
        Long id,
        String name)
{
        public DepartmentDTO ( Department department) {
                this(department.getId(), department.getName());
        }
}
