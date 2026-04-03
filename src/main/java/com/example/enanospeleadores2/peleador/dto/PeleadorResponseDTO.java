package com.example.enanospeleadores2.peleador.dto;

public record PeleadorResponseDTO(
        Long id,
        String name,
        String biografia,
        String historia,
        Integer nivel,
        Integer fuerza,
        Integer defensa,
        Integer velocidad,
        Integer resistencia
) {
}
