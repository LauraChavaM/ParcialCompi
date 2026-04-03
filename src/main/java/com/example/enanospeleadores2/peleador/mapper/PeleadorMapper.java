package com.example.enanospeleadores2.peleador.mapper;

import com.example.enanospeleadores2.peleador.dto.PeleadorCreateDTO;
import com.example.enanospeleadores2.peleador.dto.PeleadorResponseDTO;
import com.example.enanospeleadores2.peleador.dto.PeleadorUpdateDTO;
import com.example.enanospeleadores2.peleador.model.Peleador;

public class PeleadorMapper {

    private PeleadorMapper() {
    }

    public static Peleador toEntity(PeleadorCreateDTO dto) {
        Peleador peleador = new Peleador();
        peleador.setName(dto.name());
        peleador.setBiografia(dto.biografia());
        peleador.setHistoria(dto.historia());
        peleador.setNivel(dto.nivel());
        peleador.setFuerza(dto.fuerza());
        peleador.setDefensa(dto.defensa());
        peleador.setVelocidad(dto.velocidad());
        peleador.setResistencia(dto.resistencia());
        return peleador;
    }

    public static void updateEntity(Peleador peleador, PeleadorUpdateDTO dto) {
        if (dto.biografia() != null) peleador.setBiografia(dto.biografia());
        if (dto.historia() != null) peleador.setHistoria(dto.historia());
        if (dto.nivel() != null) peleador.setNivel(dto.nivel());
        if (dto.fuerza() != null) peleador.setFuerza(dto.fuerza());
        if (dto.defensa() != null) peleador.setDefensa(dto.defensa());
        if (dto.velocidad() != null) peleador.setVelocidad(dto.velocidad());
        if (dto.resistencia() != null) peleador.setResistencia(dto.resistencia());
    }

    public static PeleadorResponseDTO toDto(Peleador peleador) {
        return new PeleadorResponseDTO(
                peleador.getId(),
                peleador.getName(),
                peleador.getBiografia(),
                peleador.getHistoria(),
                peleador.getNivel(),
                peleador.getFuerza(),
                peleador.getDefensa(),
                peleador.getVelocidad(),
                peleador.getResistencia()
        );
    }
}