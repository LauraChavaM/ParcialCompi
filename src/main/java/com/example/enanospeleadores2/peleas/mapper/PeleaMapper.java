package com.example.enanospeleadores2.peleas.mapper;

import com.example.enanospeleadores2.peleas.dto.PeleaResponseDTO;
import com.example.enanospeleadores2.peleas.model.Pelea;
import com.example.enanospeleadores2.peleador.model.Peleador;

import java.util.List;

public class PeleaMapper {

    private PeleaMapper() {
    }

    public static PeleaResponseDTO toDto(Pelea pelea) {

        List<Long> peleadorIds = pelea.getPeleadores()
                .stream()
                .map(Peleador::getId)
                .toList();

        Long ganadorId = pelea.getGanador() != null
                ? pelea.getGanador().getId()
                : null;

        return new PeleaResponseDTO(
                pelea.getId(),
                peleadorIds,
                ganadorId,
                pelea.getFecha(),
                pelea.getResumen()
        );
    }
}
