package com.example.enanospeleadores2.peleas.service;

import com.example.enanospeleadores2.peleas.dto.PeleaCreateDTO;
import com.example.enanospeleadores2.peleas.dto.PeleaResponseDTO;
import com.example.enanospeleadores2.peleas.mapper.PeleaMapper;
import com.example.enanospeleadores2.peleas.model.Pelea;
import com.example.enanospeleadores2.peleas.repository.PeleasRepository;
import com.example.enanospeleadores2.peleador.model.Peleador;
import com.example.enanospeleadores2.peleador.repository.PeleadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class PeleaService {

    private final PeleasRepository peleasRepository;
    private final PeleadorRepository peleadorRepository;

    public PeleaResponseDTO create(PeleaCreateDTO dto) {

        List<Peleador> peleadores = dto.peleadorIds().stream()
                .map(id -> peleadorRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Peleador no encontrado")))
                .toList();

        Pelea pelea = new Pelea();
        pelea.setPeleadores(peleadores);
        pelea.setFecha(LocalDateTime.now());

        //ganadores aleatorios
        Peleador ganador = peleadores.get(new Random().nextInt(peleadores.size()));
        pelea.setGanador(ganador);

        pelea.setResumen("El ganador fue " + ganador.getName());
        peleasRepository.save(pelea);
        return PeleaMapper.toDto(pelea);
    }

    public PeleaResponseDTO findById(Long id) {
        Pelea pelea = peleasRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelea no encontrada"));
        return PeleaMapper.toDto(pelea);
    }

    public List<PeleaResponseDTO> findAll() {
        return peleasRepository.findAll()
                .stream()
                .map(PeleaMapper::toDto)
                .toList();
    }
}
