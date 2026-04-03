package com.example.enanospeleadores2.peleador.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PeleadorCreateDTO(

        @NotBlank(message = "El nombre es obligatorio")
        @Size(max = 120, message = "El nombre no puede superar 120 caracteres")
        String name,

        @NotBlank(message = "La biografía es obligatoria")
        @Size(max = 500, message = "La biografía no puede superar 500 caracteres")
        String biografia,

        @NotBlank(message = "La historia es obligatoria")
        @Size(max = 500, message = "La historia no puede superar 500 caracteres")
        String historia,

        @NotNull(message = "El nivel es obligatorio")
        @Min(value = 1, message = "El nivel debe ser mayor o igual a 1")
        Integer nivel,

        @NotNull(message = "La fuerza es obligatoria")
        @Min(value = 0, message = "La fuerza no puede ser negativa")
        Integer fuerza,

        @NotNull(message = "La defensa es obligatoria")
        @Min(value = 0, message = "La defensa no puede ser negativa")
        Integer defensa,

        @NotNull(message = "La velocidad es obligatoria")
        @Min(value = 0, message = "La velocidad no puede ser negativa")
        Integer velocidad,

        @NotNull(message = "La resistencia es obligatoria")
        @Min(value = 0, message = "La resistencia no puede ser negativa")
        Integer resistencia
) {
}