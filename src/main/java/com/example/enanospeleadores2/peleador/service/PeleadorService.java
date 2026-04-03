package com.example.enanospeleadores2.peleador.service;

import com.example.enanospeleadores2.peleador.dto.PeleadorCreateDTO;
import com.example.enanospeleadores2.peleador.dto.PeleadorResponseDTO;
import com.example.enanospeleadores2.peleador.dto.PeleadorUpdateDTO;
import com.example.enanospeleadores2.peleador.mapper.PeleadorMapper;
import com.example.enanospeleadores2.peleador.model.Peleador;
import com.example.enanospeleadores2.peleador.repository.PeleadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PeleadorService {

    private final PeleadorRepository peleadorRepository;

    public PeleadorResponseDTO create(PeleadorCreateDTO dto) {
        Peleador peleador = PeleadorMapper.toEntity(dto);
        peleadorRepository.save(peleador);
        return PeleadorMapper.toDto(peleador);
    }

    public PeleadorResponseDTO findById(Long id) {
        Peleador peleador = peleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peleador no encontrado"));
        return PeleadorMapper.toDto(peleador);
    }

    public List<PeleadorResponseDTO> findAll() {
        return peleadorRepository.findAll()
                .stream()
                .map(PeleadorMapper::toDto)
                .toList();
    }

    public PeleadorResponseDTO update(Long id, PeleadorUpdateDTO dto) {
        Peleador peleador = peleadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Peleador no encontrado"));
        PeleadorMapper.updateEntity(peleador, dto);
        peleadorRepository.save(peleador);
        return PeleadorMapper.toDto(peleador);
    }

    public void delete(Long id) {
        peleadorRepository.deleteById(id);
    }
}
