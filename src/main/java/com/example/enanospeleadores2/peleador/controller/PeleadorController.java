package com.example.enanospeleadores2.peleador.controller;

import com.example.enanospeleadores2.peleador.dto.PeleadorCreateDTO;
import com.example.enanospeleadores2.peleador.dto.PeleadorResponseDTO;
import com.example.enanospeleadores2.peleador.dto.PeleadorUpdateDTO;
import com.example.enanospeleadores2.peleador.service.PeleadorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/peleadores")
public class PeleadorController {

    private final PeleadorService peleadorService;

    public PeleadorController(PeleadorService peleadorService) {
        this.peleadorService = peleadorService;
    }

    @GetMapping
    public List<PeleadorResponseDTO> findAll() {
        return peleadorService.findAll();
    }

    @GetMapping("/{id}")
    public PeleadorResponseDTO findById(@PathVariable Long id) {
        return peleadorService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PeleadorResponseDTO create(@Valid @RequestBody PeleadorCreateDTO dto) {
        return peleadorService.create(dto);
    }

    @PutMapping("/{id}")
    public PeleadorResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody PeleadorUpdateDTO dto
    ) {
        return peleadorService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        peleadorService.delete(id);
    }
}