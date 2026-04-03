package com.example.enanospeleadores2.users.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdateDTO(

        @NotBlank(message = "El nombre de usuario no puede estar vacío")
        @Size(max = 100, message = "El nombre de usuario no puede superar 100 caracteres")
        String username
) {
}
