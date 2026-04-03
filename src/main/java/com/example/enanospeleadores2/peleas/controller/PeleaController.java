package com.example.enanospeleadores2.peleas.controller;

import com.example.enanospeleadores2.peleas.dto.PeleaCreateDTO;
import com.example.enanospeleadores2.peleas.dto.PeleaResponseDTO;
import com.example.enanospeleadores2.peleas.service.PeleaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peleas")
public class PeleaController {

    private final PeleaService peleaService;

    public PeleaController(PeleaService peleaService) {
        this.peleaService = peleaService;
    }

    @GetMapping
    public List<PeleaResponseDTO> findAll() {
        return peleaService.findAll();
    }

    @GetMapping("/{id}")
    public PeleaResponseDTO findById(@PathVariable Long id) {
        return peleaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeleaResponseDTO create(@Valid @RequestBody PeleaCreateDTO dto) {
        return peleaService.create(dto);
    }
}