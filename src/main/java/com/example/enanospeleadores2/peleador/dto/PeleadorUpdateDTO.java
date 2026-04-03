package com.example.enanospeleadores2.peleador.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public record PeleadorUpdateDTO(

        @Size(max = 500, message = "La biografía no puede superar 500 caracteres")
        String biografia,

        @Size(max = 500, message = "La historia no puede superar 500 caracteres")
        String historia,

        @Min(value = 1, message = "El nivel debe ser mayor o igual a 1")
        Integer nivel,

        @Min(value = 0, message = "La fuerza no puede ser negativa")
        Integer fuerza,

        @Min(value = 0, message = "La defensa no puede ser negativa")
        Integer defensa,

        @Min(value = 0, message = "La velocidad no puede ser negativa")
        Integer velocidad,

        @Min(value = 0, message = "La resistencia no puede ser negativa")
        Integer resistencia
) {
}