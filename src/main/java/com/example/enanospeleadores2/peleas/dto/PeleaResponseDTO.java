package com.example.enanospeleadores2.peleas.dto;

import java.time.LocalDateTime;
import java.util.List;

public record PeleaResponseDTO (
        Long id,
        List<Long> peleadorIds,
        Long ganadorId,
        LocalDateTime fecha,
        String resumen
) {
}
