package com.example.enanospeleadores2.peleas.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record PeleaCreateDTO(

        @NotNull(message = "La lista de peleadores es obligatoria")
        @NotEmpty(message = "Debe haber al menos dos peleadores")
        @Size(min = 2, max = 2, message = "La pelea debe tener exactamente dos peleadores")
        List<Long> peleadorIds
) {
}